import { Component, OnInit } from '@angular/core';
import {Purchase} from "../purchase-model";
import {ActivatedRoute, Router} from "@angular/router";
import {PurchasesService} from "../purchase-service";

@Component({
  selector: 'app-purchase-show',
  templateUrl: './purchase-show.component.html',
  styleUrls: ['./purchase-show.component.css']
})
export class PurchaseShowComponent implements OnInit {

  purchases: Array<Purchase> = new Array<Purchase>();
  droidId: any;
  clientId: any;
  constructor(private service: PurchasesService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(): void {
    this.droidId = this.route.snapshot.queryParams.catId
    this.clientId = this.route.snapshot.queryParams.customerId
    if (typeof this.droidId === "undefined")
      this.droidId= null
    if (typeof this.clientId === "undefined")
      this.clientId= null
    // @ts-ignore
   this.service.getAllPurchases().subscribe(purchases => {this.purchases = purchases; console.log(purchasees)}) ;
  }



  navigateToAdd(): void {
    if (this.droidId != null)
      this.router.navigate(['addDroid'], {queryParams: {catId: this.droidId}}).then(_ => {
      });
    else this.router.navigate(['addPurchase'], {queryParams: {customerId: this.clientId}}).then(_ => {
    });
  }

  onBack() {
    if (this.droidId != null)
      this.router.navigate(['showDroids']).then(_ => {
      })
    else this.router.navigate(['showClients']).then(_ => {
    })
  }

}
