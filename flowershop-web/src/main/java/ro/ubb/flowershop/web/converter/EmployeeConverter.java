package ro.ubb.flowershop.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.web.dto.EmployeeDto;

@Component
public class EmployeeConverter extends BaseConverter<Employee, EmployeeDto>{


    @Override
    public Employee convertDtoToModel(EmployeeDto dto) {

        Employee employee = Employee.builder()
                .username(dto.getUsername())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .role(dto.getRole())
                .dateOfBirth(dto.getDateOfBirth())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .build();

        employee.setId(dto.getId());
        return employee;
    }

    @Override
    public EmployeeDto convertModelToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(employee.getUsername(), employee.getFirstName(),
                employee.getLastName(), employee.getRole(), employee.getDateOfBirth(),
                employee.getPhoneNumber(), employee.getPassword());
        employeeDto.setId(employee.getId());
        return employeeDto;
    }
}
