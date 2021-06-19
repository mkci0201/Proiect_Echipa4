import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeDetailsComponent } from './employees/employee-details/employee-details.component';
import { EmployeeListComponent } from './employees/employee-list/employee-list.component';
import { EmployeeNewComponent } from './employees/employee-new/employee-new.component';

import {AppRoutingModule} from "./app-routing.module";
import {EmployeeService} from "./employees/shared/employee.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './products/product-details/product-details.component';
import { ProductListComponent } from './products/product-list/product-list.component';
import { ProductNewComponent } from './products/product-new/product-new.component';
import {ProductService} from "./products/shared/product.service";
import { OrderedProductsComponent } from './orderedproducts/orderedproducts.component';
import { OrderedProductNewComponent } from './orderedproducts/orderedproduct-new/orderedproduct-new.component';
import { OrderedProductListComponent } from './orderedproducts/orderedproduct-list/orderedproduct-list.component';
import { OrderedProductDetailsComponent } from './orderedproducts/orderedproduct-details/orderedproduct-details.component';
import {OrderedProductService} from "./orderedproducts/shared/ordered-product.service";
import { HeaderComponent } from './header/header.component';
import { ShoporderComponent } from './shoporder/shoporder.component';
import { ShoporderDetailsComponent } from './shoporder/shoporder-details/shoporder-details.component';
import { ShoporderNewComponent } from './shoporder/shoporder-new/shoporder-new.component';
import { ShoporderListComponent } from './shoporder/shoporder-list/shoporder-list.component';
import { LoginComponent } from './login/login.component';
import {HttpInterceptorService} from "./login/shared/http-interceptor.service";
import {ShopOrderService} from "./shoporder/shared/shoporder.service";

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    EmployeeNewComponent,
    ProductsComponent,
    ProductDetailsComponent,
    ProductListComponent,
    ProductNewComponent,
    OrderedProductsComponent,
    OrderedProductNewComponent,
    OrderedProductListComponent,
    OrderedProductDetailsComponent,
    HeaderComponent,
    ShoporderComponent,
    ShoporderDetailsComponent,
    ShoporderNewComponent,
    ShoporderListComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeService, ProductService, OrderedProductService, ShopOrderService,
    {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorService,
    multi: true
  }],

  bootstrap: [AppComponent]
})
export class AppModule {

}
