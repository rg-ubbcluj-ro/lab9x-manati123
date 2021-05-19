export class Client {
  id: number = 0;
  name: string;
  phoneNumber: string;
  address: string;

  constructor(name: string = "", phoneNumber: string = "", address = "") {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }
}

export class clientsDTO {
  clients: Array<Client> = new Array<Client>()
}
