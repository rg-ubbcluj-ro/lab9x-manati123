import {Droid} from "../droids/droids-model";
import {Client} from "../clients/clients-model";

export class ReportDTO {
  totalCash: number;
  droid: Droid;


  constructor(totalCash: number = 0, droid: Droid) {
    this.totalCash = totalCash;
    this.droid = droid;
  }
}

export class ReportsDTO {
  mostExpensiveModels: Array<ReportDTO> = new Array<ReportDTO>();
}
