import { Component, OnInit } from '@angular/core';
import {ClientsService} from "../clients-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  constructor(private service: ClientsService, private router: Router) { }

  ngOnInit(): void {
  }

  addClient(data: any): void{
    this.service.addCustomer(data.name,data.phoneNumber,data.address).subscribe(()=>this.router.navigate(['showClients']).then(_ => {}));
  }

  onCancel(): void {
    this.router.navigate(['showClients']).then(_ => {});
  }

}
