package ro.ubb.flowershop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.service.EmployeeService;
import ro.ubb.flowershop.web.converter.EmployeeConverter;
import ro.ubb.flowershop.web.dto.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    @RequestMapping(value = "/employees/", method = RequestMethod.PUT)
    public EmployeeDto addEmployee(
            @RequestBody final EmployeeDto dto) {

        Employee newEmployee = employeeService.addEmployee(
                employeeConverter.convertDtoToModel(dto)
        );

        return employeeConverter.convertModelToDto(newEmployee);
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
    public EmployeeDto findOne(int employeeId){

        Employee employee = employeeService.findOne(employeeId);

        return employeeConverter.convertModelToDto(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeService.getAllEmployees();

        return new ArrayList<>(employeeConverter.convertModelsToDtos(employees));
    }






}
