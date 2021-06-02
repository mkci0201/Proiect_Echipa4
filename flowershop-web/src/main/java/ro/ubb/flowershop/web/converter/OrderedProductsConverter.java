package ro.ubb.flowershop.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.OrderedProduct;
import ro.ubb.flowershop.web.dto.OrderedProductDto;

@Component
public class OrderedProductsConverter extends BaseConverter<OrderedProduct, OrderedProductDto>{
    @Override
    public OrderedProduct convertDtoToModel(OrderedProductDto dto) {
        OrderedProduct orderedProduct = null;//new OrderedProduct(dto.getProduct(), dto.getShopOrder(), dto.getQuantity());
        dto.setId(dto.getId());
        return orderedProduct;
    }

    @Override
    public OrderedProductDto convertModelToDto(OrderedProduct orderedProduct) {
        OrderedProductDto orderedProductDto = null;//new OrderedProductDto(orderedProduct.getProduct(),
                //orderedProduct.getShopOrder(), orderedProduct.getQuantity());
        //OrderedProductDto.setId(orderedProduct.getId());
        return orderedProductDto;
    }
}
