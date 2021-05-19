import { Component, OnInit } from '@angular/core';
import {ClientsService} from "../clients-service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-delete-client',
  templateUrl: './delete-client.component.html',
  styleUrls: ['./delete-client.component.css']
})
export class DeleteClientComponent implements OnInit {

  constructor(private service: ClientsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  onYes(): void {
    this.service.deleteCustomer(this.route.snapshot.queryParams.id).subscribe(() => {
      this.router.navigate(['showClients']).then(_ => {
      });
    });
  }

  onNo(): void {
    this.router.navigate(['showClients']).then(_ => {
    });
  }

}
