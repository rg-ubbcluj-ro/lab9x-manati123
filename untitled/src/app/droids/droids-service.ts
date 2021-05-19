import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {Droid, DroidsDTO} from "./droids-model";
import {map} from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class DroidsService{
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  private backendUrl = 'http://localhost:8081/';

  constructor(private http: HttpClient){}

  getDroids(): Observable<DroidsDTO>{
    //console.log(this.http.get<DroidsDTO>(this.backendUrl+ 'droids'))
    // @ts-ignore
    return this.http.get<DroidsDTO>(this.backendUrl+ 'droid')["droids"];
  }

  getDroidById(id: number): Observable<Droid>{
    return this.http.get<Droid>(this.backendUrl + `droids/${id}`,{});
  }

  getDroidsByModel(model: string): Observable<Droid[]>{
    // @ts-ignore
    console.log(this.http.get<Droid[]>(this.backendUrl + `droid/${model}`,{}).subscribe(x => console.log(x["elements"])))
    return this.http.get<Droid[]>(this.backendUrl + `droid/${model}`,{});
  }

  addDroid(powerUsage: number, price: number, batteryTime: number, model: string, driver: boolean): Observable<any>{
    return this.http.post(this.backendUrl + 'droids', new Droid(powerUsage,price,batteryTime,model,driver));
  }


  deleteDroid(droidId: number): Observable<any>{
    return this.http.delete(this.backendUrl + `/droids/${droidId}`);
  }

  updateDroid(droidId: number, model: string, powerUsage: number, batteryTime: number, driver: boolean, price: number): Observable<any>{
    return this.http.put(this.backendUrl+ `droids/${droidId}`, {
      model: model,
      powerUsage: powerUsage,
      driver: driver,
      price: price
    })
  }
}
