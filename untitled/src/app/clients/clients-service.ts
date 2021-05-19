import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Client, clientsDTO} from "./clients-model";


@Injectable({
  providedIn: 'root'
})
export class ClientsService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  private backendUrl = 'http://localhost:8081/clients';

  result: Client[] = []
  constructor(private http: HttpClient) {
  }

  getCustomers(): Observable<clientsDTO> {
    //this.http.get<clientsDTO>(this.backendUrl).subscribe(c => console.log(c));

    // @ts-ignore
    return this.http.get<Array<Client>>(this.backendUrl);
  }



  getCustomer(customerId: number): Observable<Client> {
    // @ts-ignore

    return this.http.get<Client>(this.backendUrl).pipe(
      // @ts-ignore
      map((Clients: Client[]) => Clients["elements"].find(c => c.id == customerId)))
  }


  addCustomer(name: string, phoneNumber: string, address: string): Observable<any> {
    //console.log(new Client(name, phoneNumber,address))
    return this.http.post(this.backendUrl, new Client(name, phoneNumber, address));
  }

  deleteCustomer(customerId: number): Observable<any> {
    return this.http.delete(this.backendUrl + `/${customerId}`);
  }

  updateCustomer(customerId: number, newName: string, newPhoneNumber: string, newAddress: string): Observable<any> {

    return this.http.put(this.backendUrl + `/${customerId}`, {
      name: newName,
      phoneNumber: newPhoneNumber,
      address: newAddress
    });
  }
}
