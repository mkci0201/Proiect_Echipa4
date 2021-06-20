import { Component, OnInit } from '@angular/core';
import {Employee} from "../shared/employee.model";
import {EmployeeService} from "../shared/employee.service";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  errorMessage: string;
  employees: Array<Employee>;
  selectedEmployee: Employee;

  constructor(private employeeService: EmployeeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllEmployees();
  }

  getAllEmployees() {
    this.employeeService.getAllEmployees()
      .subscribe(
        employees => this.employees = employees,
        error => this.errorMessage = <any>error
      );
  }

  gotoDetail(employee): void {
    this.router.navigate(['/employee/detail', employee.id]);
  }

  delete(employee: Employee): void {
    this.employeeService.deleteEmployee(employee.id)
      .subscribe(_ => {
        this.employees = this.employees.filter(s => s !== employee);
        if (this.selectedEmployee === employee) {
          this.selectedEmployee = null;
        }
      });
  }
}
