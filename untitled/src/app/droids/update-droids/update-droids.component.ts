import { Component, OnInit } from '@angular/core';
import {DroidsService} from "../droids-service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-droids',
  templateUrl: './update-droids.component.html',
  styleUrls: ['./update-droids.component.css']
})
export class UpdateDroidsComponent implements OnInit {

  model=""
  driver=true
  price=0
  batteryTime=0
  powerUsage=0
  constructor(private service: DroidsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.service.getDroidById(this.route.snapshot.queryParams.id).subscribe(droid => {
      this.model = droid.model
      this.driver = droid.driver
      this.price = droid.price;
      this.batteryTime = droid.batteryTime
      this.powerUsage = droid.powerUsage;
    });
  }

  updateDroid(data: { model: string; powerUsage: number; batteryTime: number; driver: boolean; price: number; }): void{
    const id = this.route.snapshot.queryParams.id;
    this.service.updateDroid(id,data.model,data.powerUsage,data.batteryTime,data.driver,data.price).subscribe(() => {
      this.router.navigate(['showDroids']).then(_ => {});
    })
  }

  onCancel(): void {
    this.router.navigate(['showDroids']).then(_ => {
    });
  }

}
