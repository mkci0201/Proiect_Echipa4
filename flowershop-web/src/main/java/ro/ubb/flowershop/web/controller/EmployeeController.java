package ro.ubb.flowershop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.EmployeeRole;
import ro.ubb.flowershop.core.service.EmployeeService;

import ro.ubb.flowershop.web.converter.EmployeeConverter;
import ro.ubb.flowershop.web.dto.EmployeeDto;
import ro.ubb.flowershop.web.dto.ShopOrderDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    @RequestMapping(value = "api/employees", method = RequestMethod.POST)
    public EmployeeDto addEmployee(@RequestBody EmployeeDto dto) {

        Employee newEmployee = employeeService.addEmployee(
                employeeConverter.convertDtoToModel(dto)
        );

        return employeeConverter.convertModelToDto(newEmployee);
    }

    @RequestMapping(value = "api/employees/{employeeId}", method = RequestMethod.PUT)
    public EmployeeDto updateEmployee(@PathVariable int employeeId, @RequestBody EmployeeDto dto){
        return employeeConverter.convertModelToDto(employeeService
                .updateEmployee(employeeId, employeeConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "api/employees/{employeeId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable int employeeId){

        employeeService.deleteEmployee(employeeId);

        if(employeeService.getAllEmployees().contains(employeeId)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }else
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "api/employees/{employeeId}", method = RequestMethod.GET)
    public EmployeeDto findOne(@PathVariable int employeeId){

        Employee employee = employeeService.findOne(employeeId);

        return employeeConverter.convertModelToDto(employee);
    }

    @RequestMapping(value = "api/employees", method = RequestMethod.GET)
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeService.getAllEmployees();

        return new ArrayList<>(employeeConverter.convertModelsToDtos(employees));
    }
    @RequestMapping(value = "api/employeesRole/{role}", method = RequestMethod.GET)
    public List<EmployeeDto>findAllByRole(@PathVariable EmployeeRole role){

        List<Employee> employees = employeeService.findAllByRole(role);
        return new ArrayList<>(employeeConverter.convertModelsToDtos(employees));

    }

 /*   @RequestMapping(value = "api/employeesWithShoporder", method = RequestMethod.GET)
    public SetJoin<EmployeeDto, ShopOrderDto>findAllShopOrdersPerEmployee(){

        List<Employee> employees = employeeService.findAllShopOrdersPerEmployee();
        return new <>(employeeConverter.convertModelsToDtos(employees));

    }*/
}
