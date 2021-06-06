import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Employee} from "./employee.model";

@Injectable()
export class EmployeeService {
  private employeesUrl = 'http://localhost:8080/api/employees';

  constructor(private httpClient: HttpClient) {

  }

  addEmployee(username: string, firstName: string, lastName: string, role: number,
              dateOfBirth: string, phoneNumber: string, password: string): Observable<Employee>
  {
    let employee = {username, firstName, lastName, role, dateOfBirth, phoneNumber, password};
    return this.httpClient.post<Employee>(this.employeesUrl, employee)
  }

  updateEmployee(employee): Observable<Employee> {
    const url = `${this.employeesUrl}/${employee.id}`;
    return this.httpClient.put<Employee>(url, employee);
  }


  deleteEmployee(id: number) : Observable<Employee> {
    const url  = `${this.employeesUrl}/${id}`;
    return this.httpClient.delete<Employee>(url);
  }

  findOne(id: number) : Observable<Employee>{
    return this.getAllEmployees().pipe(map(employees => employees.find(employee => employee.id === id)));
  }

  getAllEmployees() : Observable<Employee[]>{
    return this.httpClient.get<Array<Employee>>(this.employeesUrl);

  }

}
