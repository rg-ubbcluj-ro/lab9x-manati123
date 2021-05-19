import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Purchase, PurchaseAddDTO, PurchasesDTO} from "../purchases/purchase-model";
import {map} from "rxjs/operators";
import {Receipt, ReceiptDto} from "./receipt";

@Injectable({
  providedIn: 'root'
})
export class ReceiptService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  private backendUrl = 'http://localhost:8081/receipts';


  constructor(private http: HttpClient) {
  }

  getReceipts(): Observable<Array<Receipt>> {
    //console.log(this.http.get<Array<Receipt>>(this.backendUrl).subscribe(x => console.log(x)))
    //this.http.get<PurchasesDTO>(this.backendUrl).subscribe(x => consol e.log("x"))
    //return this.http.get<PurchasesDTO>(this.backendUrl + `/${clientId}`).pipe(map(purchases => purchases.purchases))
    return this.http.get<Array<Receipt>>(this.backendUrl);
  }

  addReceipt(totalPrice: number, purchaseID: number): Observable<any> {
    return this.http.put(this.backendUrl, new Receipt(totalPrice,purchaseID));
  }


}
