export class Droid{

  id: number = 0;
  powerUsage: number;
  price: number;
  batteryTime: number;
  model: string;
  driver: boolean;


  constructor( powerUsage: number, price: number, batteryTime: number, model: string, driver: boolean) {

    this.powerUsage = powerUsage;
    this.price = price;
    this.batteryTime = batteryTime;
    this.model = model;
    this.driver = driver;
  }

}

export class DroidsDTO{
  droids!: Array<Droid>;
}
