package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.EmployeeRole;
import ro.ubb.flowershop.core.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {

        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(int employeeId, String firstName, String lastName, EmployeeRole role, String phoneNumber, String password){

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        employee.ifPresent(e->{
            e.setFirstName(firstName);
            e.setLastName(lastName);
            e.setRole(role);
            e.setPhoneNumber(phoneNumber);
            e.setPassword(password);
        });

        return employee.orElse(null);
    }


    @Override
    public void deleteEmployee(int employeeId) {

       employeeRepository.deleteById(employeeId);


    }

    @Override
    public Employee findOne(int employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }
}
