package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.EmployeeRole;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.core.repository.EmployeeRepository;

import javax.persistence.criteria.SetJoin;
import java.util.List;
import java.util.Optional;

@Component
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
    public Employee updateEmployee(int employeeId, Employee employee){

        Optional<Employee> uEmployee = employeeRepository.findById(employeeId);

        uEmployee.ifPresent(e->{
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setRole(employee.getRole());
            e.setPhoneNumber(employee.getPhoneNumber());
            e.setPassword(employee.getPassword());
        });

        return uEmployee.orElse(null);
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

  /*  @Override
    public SetJoin<Employee, ShopOrder> findAllShopOrdersPerEmployee(){
        return employeeRepository.findAllShopOrdersPerEmployee();
    }*/

    @Override
    public List<Employee> findAllByRole(EmployeeRole role){
        return employeeRepository.findAllByRole(role);
    }

}

