import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-switcher',
  templateUrl: './switcher.component.html',
  styleUrls: ['./switcher.component.css']
})
export class SwitcherComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onDroids(){
    this.router.navigate(['showDroids']).then(_ => {});
  }

  onPurchases(){
    this.router.navigate(['showPurchases']).then(_ => {});
  }

  onClients(){
    this.router.navigate(['showClients']).then(_ => {});
  }

  onReceiepts(){
    this.router.navigate(['showReceipts']).then(_ => {});
  }

  onReport() {
    this.router.navigate(['report']).then(_ => {});
  }
}
