import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Purchase, PurchaseAddDTO, PurchasesDTO} from "./purchase-model";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PurchasesService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  private backendUrl = 'http://localhost:8081/purchases';


  constructor(private http: HttpClient) {
  }

  getPurchases(droidId: number, clientId: number): Observable<Array<Purchase>> {
    this.http.get<PurchasesDTO>(this.backendUrl).subscribe(x => console.log("x"))
    return this.http.get<PurchasesDTO>(this.backendUrl + `/${clientId}`).pipe(map(purchases => purchases.purchases))
  }

  addPurchase(price: number,
              droidId: number,
              clientId: number,): Observable<any> {
    return this.http.post(this.backendUrl, new PurchaseAddDTO(price, droidId, clientId));
  }

  getAllPurchases(): Observable<Array<Purchase>>{

    console.log(this.http.get<PurchasesDTO>(this.backendUrl).subscribe())
    return this.http.get<PurchasesDTO>(this.backendUrl).pipe(map(p => p.purchases));
  }
}
