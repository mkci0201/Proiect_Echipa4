package ro.ubb.flowershop.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.web.dto.EmployeeDto;
import ro.ubb.flowershop.web.dto.ShopOrderDto;


@Component
public class ShopOrderConverter extends BaseConverter<ShopOrder, ShopOrderDto>{

    @Autowired
    private Converter<Employee, EmployeeDto> employeeConverter;

    @Override
    public ShopOrder convertDtoToModel(ShopOrderDto dto) {
        //TODO: update shop order converter
        ShopOrder order = null;
                //new ShopOrder(dto.getDate(), dto.getCategory());
        dto.setId(dto.getId());
        return order;
    }


    @Override
    public ShopOrderDto convertModelToDto(ShopOrder order) {

        ShopOrderDto shopOrderDto = new ShopOrderDto(order.getDate(),
                order.getCategory());
        shopOrderDto.setId(order.getId());
        return shopOrderDto;
    }
}

