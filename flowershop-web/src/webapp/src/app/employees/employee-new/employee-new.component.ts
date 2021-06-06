import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../shared/employee.service";
import {Location} from '@angular/common';

@Component({
  moduleId: module.id,
  selector: 'app-employee-new',
  templateUrl: './employee-new.component.html',
  styleUrls: ['./employee-new.component.css']
})
export class EmployeeNewComponent {

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
