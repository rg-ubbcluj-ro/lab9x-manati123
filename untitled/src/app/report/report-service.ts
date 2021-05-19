import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Receipt} from "../receipts/receipt";
import {ReportsDTO} from "./report-model";

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  private backendUrl = 'http://localhost:8081/droids/sortedModels';


  constructor(private http: HttpClient) {
  }

  getReport(): Observable<ReportsDTO>{
    return this.http.get<ReportsDTO>(this.backendUrl);
  }


}
