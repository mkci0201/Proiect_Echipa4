import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {EmployeesComponent} from "./employees/employees.component";
import {EmployeeNewComponent} from "./employees/employee-new/employee-new.component";
import {EmployeeDetailsComponent} from "./employees/employee-details/employee-details.component";


const routes: Routes = [

  {path: 'employees', component: EmployeesComponent  },
  {path: 'employee/new', component: EmployeeNewComponent},
  {path: 'employee/detail/:id', component: EmployeeDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
