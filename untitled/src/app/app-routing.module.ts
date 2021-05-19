import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {SwitcherComponent} from "./switcher/switcher.component";
import {ShowDroidsComponent} from "./droids/show-droids/show-droids.component";
import {AddDroidComponent} from "./droids/add-droid/add-droid.component";
import {DeleteDroidComponent} from "./droids/delete-droid/delete-droid.component";
import {UpdateDroidsComponent} from "./droids/update-droids/update-droids.component";
import {ShowClientComponent} from "./clients/show-client/show-client.component";
import {AddClientComponent} from "./clients/add-client/add-client.component";
import {DeleteClientComponent} from "./clients/delete-client/delete-client.component";
import {UpdateClientComponent} from "./clients/update-client/update-client.component";
import {PurchaseShowComponent} from "./purchases/purchase-show/purchase-show.component";
import {PurchaseAddComponent} from "./purchases/purchase-add/purchase-add.component";
import {ReceiptShowComponent} from "./receipts/receipt-show/receipt-show.component";
import {ReceiptAddComponent} from "./receipts/receipt-add/receipt-add.component";
import {ReceiptDeleteComponent} from "./receipts/receipt-delete/receipt-delete.component";
import {ReceiptUpdateComponent} from "./receipts/receipt-update/receipt-update.component";
import {ReportComponent} from "./report/report.component";



const routes: Routes = [
  {path: '', redirectTo: 'switcher', pathMatch: 'full'},
  {path: 'switcher', component: SwitcherComponent},
  {path: 'showDroids', component: ShowDroidsComponent},
  {path: 'addDroid', component: AddDroidComponent},
  {path: 'deleteDroid', component: DeleteDroidComponent},
  {path: 'updateDroid', component: UpdateDroidsComponent},
  {path: 'showClients', component: ShowClientComponent},
  {path: 'addClient', component: AddClientComponent},
  {path: 'deleteClient', component: DeleteClientComponent},
  {path: 'updateClient', component: UpdateClientComponent},
  {path: 'showPurchases', component: PurchaseShowComponent},
  {path: 'addPurchase', component: PurchaseAddComponent},
  {path: 'showReceipts', component: ReceiptShowComponent},
  {path: 'addReceipts', component: ReceiptAddComponent},
  {path: 'deleteReceipt', component: ReceiptDeleteComponent},
  {path: 'updateReceipt', component: ReceiptUpdateComponent},
  {path: 'report', component: ReportComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
