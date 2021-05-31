package ro.ubb.flowershop.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.Order;
import ro.ubb.flowershop.web.dto.EmployeeDto;
import ro.ubb.flowershop.web.dto.OrderDto;


@Component
public class OrderConverter extends BaseConverter<Order, OrderDto>{

    @Autowired
    private Converter<Employee, EmployeeDto> employeeConverter;

    @Override
    public Order convertDtoToModel(OrderDto dto) {
        Employee employee = employeeConverter.convertDtoToModel(dto.getEmployeeDto());
        Order order = new Order(employee,dto.getDate(), dto.getCategory());
        dto.setId(dto.getId());
        return order;
    }


    @Override
    public OrderDto convertModelToDto(Order order) {
        EmployeeDto employeeDto = employeeConverter.convertModelToDto(order.getEmployee());
        OrderDto orderDto = new OrderDto(employeeDto,order.getDate(),
                order.getCategory());
        orderDto.setId(order.getId());
        return orderDto;
    }
}

