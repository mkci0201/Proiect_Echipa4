import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../shared/employee.service";
import {Location} from '@angular/common';
import { EMPLOYEE_ROLE_TYPES } from '../shared/employee.model';

@Component({
  moduleId: module.id,
  selector: 'app-employee-new',
  templateUrl: './employee-new.component.html',
  styleUrls: ['./employee-new.component.css']
})
export class EmployeeNewComponent {

  EMPLOYEE_ROLE_TYPES = EMPLOYEE_ROLE_TYPES;


  constructor(private employeeService: EmployeeService,
              private location: Location) {
  }

  goBack(): void {
    this.location.back();
  }

  addEmployee(username, firstName, lastName, role, dateOfBirth, phoneNumber, password): void {

    this.employeeService.addEmployee(username, firstName, lastName, role, dateOfBirth, phoneNumber, password)
      .subscribe(_ => this.goBack());
  }

}
