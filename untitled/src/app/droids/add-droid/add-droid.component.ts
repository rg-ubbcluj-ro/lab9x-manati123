import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {DroidsService} from "../droids-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-droid',
  templateUrl: './add-droid.component.html',
  styleUrls: ['./add-droid.component.css']
})
export class AddDroidComponent implements OnInit {

  addDroidForm = new FormGroup({
    model: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    batteryTime: new FormControl('', Validators.required),
    powerUsage: new FormControl('', Validators.required),
    driver: new FormControl('', Validators.required)
  })
  constructor(private service: DroidsService, private router: Router) { }

  ngOnInit(): void {
  }

  addDroid(): void{
    if(this.addDroidForm.get("model")?.invalid){
      alert("model cannot be empty");
      return;
    }
    if(this.addDroidForm.get("price")?.invalid){
      alert("invalid price");
      return;
    }
    if(this.addDroidForm.get("batteryTime")?.invalid)
    {
      alert("Invalid battery time!");
      return;
    }
    if(this.addDroidForm.get("powerUsage")?.invalid){
      alert("Invalid power usage!");
      return;
    }
    if(this.addDroidForm.get("driver")?.invalid){
      alert("Invalid driver! True or False");
      return;
    }
    this.service.addDroid(this.addDroidForm.get("powerUsage")?.value,this.addDroidForm.get("price")?.value,this.addDroidForm.get("batteryTime")?.value,this.addDroidForm.get("model")?.value,(this.addDroidForm.get("driver")?.value=="true" || this.addDroidForm.get("driver")?.value=="false" ||this.addDroidForm.get("driver")?.value=="True" ||this.addDroidForm.get("driver")?.value=="False")).subscribe(() =>{
      this.router.navigate(['showDroids']).then(_=>{});
    });

  }

  onCancel(): void {
    this.router.navigate(['showDroids']).then(_ => {});
  }

}
