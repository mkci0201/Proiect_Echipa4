import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {EmployeesComponent} from "./employees/employees.component";
import {EmployeeNewComponent} from "./employees/employee-new/employee-new.component";
import {EmployeeDetailsComponent} from "./employees/employee-details/employee-details.component";
import {ProductsComponent} from "./products/products.component";
import {ProductNewComponent} from "./products/product-new/product-new.component";
import {ProductDetailsComponent} from "./products/product-details/product-details.component";
import {OrderedProductsComponent} from "./orderedproducts/orderedproducts.component";
import {OrderedProductNewComponent} from "./orderedproducts/orderedproduct-new/orderedproduct-new.component";
import {OrderedProductDetailsComponent} from "./orderedproducts/orderedproduct-details/orderedproduct-details.component";
import {LoginComponent} from "./login/login.component";


const routes: Routes = [

  {path: 'employees', component: EmployeesComponent  },
  {path: 'employee/new', component: EmployeeNewComponent},
  {path: 'employee/detail/:id', component: EmployeeDetailsComponent},
  {path: 'products', component: ProductsComponent},
  {path: 'product/new', component: ProductNewComponent},
  {path: 'product/detail/:id', component: ProductDetailsComponent},
  {path: 'orders', component: OrderedProductsComponent},
  {path: 'order/new', component: OrderedProductNewComponent},
  {path: 'order/detail/:id', component: OrderedProductDetailsComponent},
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
