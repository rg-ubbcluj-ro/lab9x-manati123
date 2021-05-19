
export class Receipt {
  id: any;
  totalPrice: number;
  purchaseID: number;


  constructor(totalPrice: number = 0, purchaseID: number) {
    this.totalPrice = totalPrice;

    this.purchaseID = purchaseID

  }
}

export class ReceiptDto{

  receipts: Array<Receipt> = new Array<Receipt>()
}
