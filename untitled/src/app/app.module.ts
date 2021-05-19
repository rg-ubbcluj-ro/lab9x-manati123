import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {CommonModule} from '@angular/common';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AddDroidComponent } from './droids/add-droid/add-droid.component';
import { DeleteDroidComponent } from './droids/delete-droid/delete-droid.component';
import { ShowDroidsComponent } from './droids/show-droids/show-droids.component';
import { UpdateDroidsComponent } from './droids/update-droids/update-droids.component';
import { AddClientComponent } from './clients/add-client/add-client.component';
import { UpdateClientComponent } from './clients/update-client/update-client.component';
import { DeleteClientComponent } from './clients/delete-client/delete-client.component';
import { ShowClientComponent } from './clients/show-client/show-client.component';
import { SwitcherComponent } from './switcher/switcher.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ReceiptAddComponent } from './receipts/receipt-add/receipt-add.component';
import { ReceiptUpdateComponent } from './receipts/receipt-update/receipt-update.component';
import { ReceiptShowComponent } from './receipts/receipt-show/receipt-show.component';
import { ReceiptDeleteComponent } from './receipts/receipt-delete/receipt-delete.component';
import { PurchaseAddComponent } from './purchases/purchase-add/purchase-add.component';
import { PurchaseShowComponent } from './purchases/purchase-show/purchase-show.component';
import { ReportComponent } from './report/report.component';


@NgModule({
  declarations: [
    AppComponent,
    AddDroidComponent,
    DeleteDroidComponent,
    ShowDroidsComponent,
    UpdateDroidsComponent,
    AddClientComponent,
    UpdateClientComponent,
    DeleteClientComponent,
    ShowClientComponent,
    SwitcherComponent,
    ReceiptAddComponent,
    ReceiptUpdateComponent,
    ReceiptShowComponent,
    ReceiptDeleteComponent,
    PurchaseAddComponent,
    PurchaseShowComponent,
    ReportComponent,

  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
