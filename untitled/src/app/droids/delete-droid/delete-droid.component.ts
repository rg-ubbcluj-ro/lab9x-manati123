import { Component, OnInit } from '@angular/core';
import {DroidsService} from "../droids-service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-delete-droid',
  templateUrl: './delete-droid.component.html',
  styleUrls: ['./delete-droid.component.css']
})
export class DeleteDroidComponent implements OnInit {

  constructor(private service: DroidsService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  onYes() {
    this.service.deleteDroid(this.route.snapshot.queryParams.id).subscribe(() => {
      this.router.navigate(['showDroids']).then(_ => {});
    })
  }

  onNo() {
    this.router.navigate(['showDroids']).then(_ => {});
  }
}
