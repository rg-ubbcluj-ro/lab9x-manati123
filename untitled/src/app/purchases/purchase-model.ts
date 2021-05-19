import {Droid} from "../droids/droids-model";
import {Client} from "../clients/clients-model";

export class Purchase {
  id: any;
  totalPrice: number;
  droid: Droid;
  client: Client;


  constructor(price: number = 0, droid: Droid, client: Client) {
    this.totalPrice = price;

    this.droid = droid;
    this.client = client;
    this.id = {
      catId: client.id,
      customerId: client.id
    }
  }
}

export class PurchaseAddDTO {
  totalPrice: number;
  droidId: number;
  clientId: number;


  constructor(price: number, droidId: number, clientId: number) {
    this.totalPrice = price;
    this.droidId = droidId;
    this.clientId = clientId;
  }
}

export class PurchasesDTO {
  purchases: Array<Purchase> = new Array<Purchase>()
}
