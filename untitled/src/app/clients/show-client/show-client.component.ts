import { Component, OnInit } from '@angular/core';
import {ClientsService} from "../clients-service";
import {CommonModule} from '@angular/common';


import {Router} from "@angular/router";
import {Client, clientsDTO} from "../clients-model";

@Component({
  selector: 'app-show-client',
  templateUrl: './show-client.component.html',
  styleUrls: ['./show-client.component.css']
})
export class ShowClientComponent implements OnInit {


  clients: Array<Client>;

  constructor(private service: ClientsService, private router: Router) {this.clients = new Array<Client>() }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(): void {
    this.service.getCustomers().subscribe(clients => {
      // @ts-ignore
      this.clients = clients["elements"];
      // @ts-ignore
      console.log(clients["elements"])

    });
    console.log(this.clients)
  }

  navigateToDelete(customerId: number): void {
    this.router.navigate(['deleteClient'], {queryParams: {id: customerId}}).then(_ => {
    });
  }

  navigateToAdd(): void {
    this.router.navigate(['addClient']).then(_ => {
    });
  }

  navigateToUpdate(clientId: number): void {
    this.router.navigate(['updateClient'], {queryParams: {id: clientId}}).then(_ => {
    });
  }

  navigateToPurchases(customerId: number): void {
    this.router.navigate(['showPurchases'], {queryParams: {customerId: customerId}}).then(_ => {
    });
  }

  onBack() {
    this.router.navigate(['switcher']).then(_ => {
    })
  }

}
