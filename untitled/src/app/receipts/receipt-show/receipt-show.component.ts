import { Component, OnInit } from '@angular/core';
import {Receipt} from "../receipt";
import {DroidsService} from "../../droids/droids-service";
import {Router} from "@angular/router";
import {ReceiptService} from "../receipt-service";

@Component({
  selector: 'app-receipt-show',
  templateUrl: './receipt-show.component.html',
  styleUrls: ['./receipt-show.component.css']
})
export class ReceiptShowComponent implements OnInit {

  receipts: Array<Receipt>;
  constructor(private service: ReceiptService, private router: Router) { this.receipts = new Array<Receipt>()}

  ngOnInit(): void {
    this.refresh()
  }

  refresh(): void{
    // @ts-ignore
    this.service.getReceipts().subscribe(x => {this.receipts = x["elements"]; console.log(this.receipts)})

  }

  onBack() {
    this.router.navigate(['switcher']).then(_ => {
    })
  }

  navigateToAdd() {
    this.router.navigate(['addReceipts']).then(_ => {
    });
  }

  navigateToUpdate(id: number) {
    this.router.navigate(['updateReceipt'], {queryParams: {id: id}}).then(_ => {
    });
  }

  navigateToDelete(id: number) {
    this.router.navigate(['deleteReceipt'], {queryParams: {id: id}}).then(_ => {
    });
  }
}
