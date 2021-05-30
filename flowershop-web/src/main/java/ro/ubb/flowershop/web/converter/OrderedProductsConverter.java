package ro.ubb.flowershop.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.OrderedProducts;
import ro.ubb.flowershop.web.dto.OrderedProductsDto;

@Component
public class OrderedProductsConverter extends BaseConverter<OrderedProducts, OrderedProductsDto>{
    @Override
    public OrderedProducts convertDtoToModel(OrderedProductsDto dto) {
        OrderedProducts orderedProducts = new OrderedProducts(dto.getProduct(), dto.getOrder(), dto.getQuantity());
        dto.setId(dto.getId());
        return orderedProducts;
    }

    @Override
    public OrderedProductsDto convertModelToDto(OrderedProducts orderedProducts) {
        OrderedProductsDto orderedProductsDto = new OrderedProductsDto(orderedProducts.getProduct(),
                orderedProducts.getOrder(), orderedProducts.getQuantity());
        OrderedProductsDto.setId(orderedProducts.getId());
        return orderedProductsDto;
    }
}
