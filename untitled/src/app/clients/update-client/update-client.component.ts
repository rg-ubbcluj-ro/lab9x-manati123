import { Component, OnInit } from '@angular/core';
import {ClientsService} from "../clients-service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-client',
  templateUrl: './update-client.component.html',
  styleUrls: ['./update-client.component.css']
})
export class UpdateClientComponent implements OnInit {

  name = ""
  phoneNumber = ""
  address = ""
  constructor(private service: ClientsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.service.getCustomer(this.route.snapshot.queryParams.id).subscribe(client => {
      this.name = client.name
      this.phoneNumber = client.phoneNumber
      this.address = client.address;
    })
  }

  updateClient(data: any): void {

    const id = this.route.snapshot.queryParams.id;
    this.service.updateCustomer(id, data.name, data.phoneNumber, data.address).subscribe(() => {
      this.router.navigate(['showClients']).then(_ => {
      });
    });
  }

  onCancel(): void {
    this.router.navigate(['showClients']).then(_ => {
    });
  }

}
