package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
import java.util.stream.Collectors;

@Component
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setPassword(BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt()));
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(int employeeId, Employee employee){

        Optional<Employee> uEmployee = employeeRepository.findById(employeeId);

        uEmployee
                 .ifPresent(e->{
                    e.setFirstName(employee.getFirstName());
                    e.setLastName(employee.getLastName());
                    e.setDateOfBirth(employee.getDateOfBirth());
                    e.setRole(employee.getRole());
                    e.setPhoneNumber(employee.getPhoneNumber());
                    e.setPassword(BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt()));
        });

        return uEmployee.orElse(null);
    }


    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {

        Optional<Employee> employeeRemove = employeeRepository.findById(employeeId);
        employeeRemove.ifPresent(e ->{
            e.setInactive(true);
        });

    }

    @Override
    public Employee findOne(int employeeId) {

        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow();

        if(employee != null && !employee.isInactive()){

            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll().stream().filter(e -> e.isInactive() == false).collect(Collectors.toList());
    }
    @Override
    public List<Employee> findAllByRole(EmployeeRole role){


        return employeeRepository.findAllByRole(role)
                                 .stream().filter(e -> e.isInactive() == false).collect(Collectors.toList());
    }

    @Override
    public Employee findByUsername(String username){

        Employee employee = this.employeeRepository.findByUsername(username);

        if(employee != null && !employee.isInactive()){

            return employee;
        }
        return null;
    }
}

