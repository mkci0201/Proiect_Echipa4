package ro.ubb.flowershop.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.OrderedProduct;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.web.dto.EmployeeDto;
import ro.ubb.flowershop.web.dto.OrderedProductDto;
import ro.ubb.flowershop.web.dto.ShopOrderDto;

import java.util.HashSet;
import java.util.Set;


@Component
public class ShopOrderConverter extends BaseConverter<ShopOrder, ShopOrderDto>{

    @Autowired
    private Converter<OrderedProduct, OrderedProductDto> orderedProductDtoConverter;

    @Autowired
    private Converter<Employee, EmployeeDto> employeeDtoConverter;

    @Override
     public ShopOrder convertDtoToModel(ShopOrderDto dto) {

        Set<OrderedProduct> orderedProductsList = new HashSet<>();

        for (OrderedProductDto orderedProductDto: dto.getOrderedProducts()) {
            orderedProductsList.add(orderedProductDtoConverter.convertDtoToModel(orderedProductDto));
        }

        ShopOrder order =
                new ShopOrder(dto.getDate(),
                              dto.getCategory(),
                              orderedProductsList,
                               employeeDtoConverter.convertDtoToModel(dto.getEmployee()));
        order.setId(dto.getId());
        return order;
    }


    @Override
    public ShopOrderDto convertModelToDto(ShopOrder order) {

        Set<OrderedProductDto> orderedProductDtos = new HashSet<>();

        for (OrderedProduct orderedProduct: order.getOrderedProducts()) {

            orderedProductDtos.add(orderedProductDtoConverter.convertModelToDto(orderedProduct));

        }

        ShopOrderDto shopOrderDto =
                new ShopOrderDto(order.getDate(),
                                 order.getCategory(),
                                 orderedProductDtos,
                                 employeeDtoConverter.convertModelToDto(order.getEmployee()));
        shopOrderDto.setId(order.getId());
        return shopOrderDto;
    }

}

