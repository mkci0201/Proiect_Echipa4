package ro.ubb.flowershop.core.service;

import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.EmployeeRole;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    Employee updateEmployee(int employeeId, Employee employee);
    void deleteEmployee(int employeeId);

    Employee findOne(int employeeId);
    List<Employee> getAllEmployees();

}
