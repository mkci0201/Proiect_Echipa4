"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
  var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
  if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
  else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
  return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require('@angular/core');
var EmployeeListComponent = (function () {
  function EmployeeListComponent(employeeService, router) {
    this.employeeService = employeeService;
    this.router = router;
  }
  EmployeeListComponent.prototype.ngOnInit = function () {
    this.getAllEmployees();
  };
  EmployeeListComponent.prototype.getAllEmployees = function () {
    var _this = this;
    this.employeeService.getAllEmployees()
      .subscribe(function (employees) { return _this.employees = employees; }, function (error) { return _this.errorMessage = error; });
  };
  EmployeeListComponent.prototype.onSelect = function (employee) {
    this.selectedEmployee = employee;
  };
  EmployeeListComponent.prototype.gotoDetail = function () {
    this.router.navigate(['/employee/detail', this.selectedEmployee.id]);
  };
  EmployeeListComponent = __decorate([
    core_1.Component({
      moduleId: module.id,
      selector: 'app-employee-list',
      templateUrl: './employee-list.component.html',
      styleUrls: ['./employee-list.component.css']
    })
  ], EmployeeListComponent);
  return EmployeeListComponent;
}());
exports.EmployeeListComponent = EmployeeListComponent;
