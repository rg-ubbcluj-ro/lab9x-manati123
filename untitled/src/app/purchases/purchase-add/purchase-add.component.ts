import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PurchasesService} from "../purchase-service";
import {DroidsService} from "../../droids/droids-service";
import {ClientsService} from "../../clients/clients-service";
import {Client} from "../../clients/clients-model";
import {Droid} from "../../droids/droids-model";

@Component({
  selector: 'app-purchase-add',
  templateUrl: './purchase-add.component.html',
  styleUrls: ['./purchase-add.component.css']
})
export class PurchaseAddComponent implements OnInit {


  droids: Array<Droid> = new Array<Droid>();
  clients: Array<Client> = new Array<Client>();
  droidId: any;
  clientId: any;
  totalPrice: any;
  constructor(private service: PurchasesService, private droidService: DroidsService, private customersService: ClientsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(): void {
    this.droidId = this.route.snapshot.queryParams.droidId
    this.clientId = this.route.snapshot.queryParams.clientId
    console.log(this.route.snapshot.queryParams)
    if (typeof this.droidId === "undefined")
      this.droidId = null
    if (typeof this.clientId === "undefined")
      this.clientId = null
    if (this.droidId != null)
      {
        console.log(this.customersService.getCustomers())
        // @ts-ignore
        this.customersService.getCustomers().subscribe(customers => {this.clients = customers.clients })
      }
    else {
      console.log(this.customersService.getCustomers())
      // @ts-ignore

      this.droidService.getDroids().subscribe(droids => this.droids = droids.droids)
    }
  }


  addPurchase(id: number) {
    if (!this.totalPrice) {
      alert("Invalid data")
      return
    }
    this.service.getPurchases(this.droidId, this.clientId).subscribe(purchases => {
      let currentDroidId = this.droidId
      let currentClientId = this.clientId
      if (currentDroidId == null)
        currentDroidId = id
      if (currentClientId == null)
        currentClientId = id
      if (purchases.find(purchase => purchase.droid.id == currentDroidId && purchase.client.id == currentClientId)) {
        alert("The pair is already present in the database")
        return
      }
      if (this.clientId == null) {
        this.service.addPurchase(this.totalPrice, id, this.clientId).subscribe(() => {
          this.onBack()
        })
      } else {
        this.service.addPurchase(this.totalPrice, this.droidId, id).subscribe(() => {
          this.onBack()
        })
      }
    })
  }


  onBack() {
    if (this.droidId != null)
      this.router.navigate(['showPurchases'], {queryParams: {catId: this.droidId}}).then(_ => {
      })
    else this.router.navigate(['showPurchases'], {queryParams: {customerId: this.clientId}}).then(_ => {
    })
  }
}
