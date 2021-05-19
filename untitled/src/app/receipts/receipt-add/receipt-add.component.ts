import { Component, OnInit } from '@angular/core';
import {ReceiptService} from "../receipt-service";
import {DroidsService} from "../../droids/droids-service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-receipt-add',
  templateUrl: './receipt-add.component.html',
  styleUrls: ['./receipt-add.component.css']
})
export class ReceiptAddComponent implements OnInit {

  addReceiptForm = new FormGroup({
    purchaseID: new FormControl('', Validators.required),
    totalPrice: new FormControl('', Validators.required)
  })

  constructor(private service: ReceiptService, private router: Router) { }

  ngOnInit(): void {
  }

  addReceipt(value: any) {
    // this.service.addDroid(this.addDroidForm.get("powerUsage")?.value,this.addDroidForm.get("price")?.value,this.addDroidForm.get("batteryTime")?.value,this.addDroidForm.get("model")?.value,(this.addDroidForm.get("driver")?.value=="true" || this.addDroidForm.get("driver")?.value=="false" ||this.addDroidForm.get("driver")?.value=="True" ||this.addDroidForm.get("driver")?.value=="False")).subscribe(() =>{
    //   this.router.navigate(['showDroids']).then(_=>{});
    // });
    if(value.purchaseID == null)
    {
      alert("Null purchase id!")
      return;
    }
    if(value.totalPrice == null)
    {
      alert("Price null!")
      return;
    }

    //console.log(this.addReceiptForm.get('purchaseID')?.value)

    this.service.addReceipt(value.totalPrice,value.purchaseID).subscribe(() => this.router.navigate(['showReceipts']).then(_ => {}))
  }

  onCancel() {

  }
}
