import {Component, Input, OnInit} from '@angular/core';
import {Employee, EMPLOYEE_ROLE_TYPES} from "../shared/employee.model";
import {EmployeeService} from "../shared/employee.service";
import {ActivatedRoute, Params} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {Location} from '@angular/common';


@Component({
  moduleId:module.id,
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  @Input() employee : Employee;
  EMPLOYEE_ROLE_TYPES = EMPLOYEE_ROLE_TYPES;

  constructor(private employeeService: EmployeeService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.employeeService.findOne(+params['id'])))
      .subscribe(employee => this.employee = employee);
  }

    goBack(): void {
      this.location.back();
    }

    save(): void {
      this.employeeService.updateEmployee(this.employee)
        .subscribe(_ => this.goBack());
    }

}
