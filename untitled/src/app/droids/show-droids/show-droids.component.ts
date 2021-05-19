import { Component, OnInit } from '@angular/core';
import {Droid, DroidsDTO} from "../droids-model";
import {DroidsService} from "../droids-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-show-droids',
  templateUrl: './show-droids.component.html',
  styleUrls: ['./show-droids.component.css']
})
export class ShowDroidsComponent implements OnInit {

  droids!: Droid[]  ;



  constructor(private service: DroidsService, private router: Router) { }

  ngOnInit(): void {
    this.refresh("");
  }

  refresh(model: string): void{
    // @ts-ignore
    this.service.getDroidsByModel(model).subscribe(x => this.droids = x["elements"])

   // console.log(this.droids + ' ]abcd');
  }

  navigateToDelete(droidId: number): void {
    this.router.navigate(['deleteDroid'], {queryParams: {id: droidId}}).then(_ => {
    });
  }

  navigateToAdd(): void {
    this.router.navigate(['addDroid']).then(_ => {
    });
  }

  navigateToUpdate(droidId: number): void {
    this.router.navigate(['updateDroid'], {queryParams: {id: droidId}}).then(_ => {
    });
  }



  navigateToPurchases(droidId: number): void {
    this.router.navigate(['showPurchases'], {queryParams: {droidId: droidId}}).then(_ => {
    });
  }

  onBack() {
    this.router.navigate(['switcher']).then(_ => {
    })
  }

}
