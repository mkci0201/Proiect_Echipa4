package ro.ubb.flowershop.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.OrderedProduct;
import ro.ubb.flowershop.core.model.Product;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.web.dto.OrderedProductDto;
import ro.ubb.flowershop.web.dto.ProductDto;
import ro.ubb.flowershop.web.dto.ShopOrderDto;

@Component
public class OrderedProductsConverter extends BaseConverter<OrderedProduct, OrderedProductDto>{

    @Autowired
    private Converter<Product, ProductDto> productDtoConverter;

    @Override
    public OrderedProduct convertDtoToModel(OrderedProductDto dto) {

        OrderedProduct orderedProduct =
                new OrderedProduct(productDtoConverter.convertDtoToModel(dto.getProduct()),
                                   dto.getQuantity());
        orderedProduct.setId(dto.getId());
        return orderedProduct;
    }

    @Override
    public OrderedProductDto convertModelToDto(OrderedProduct orderedProduct) {
        OrderedProductDto orderedProductDto =
                new OrderedProductDto(productDtoConverter.convertModelToDto(orderedProduct.getProduct()),
                                      orderedProduct.getQuantity());
        orderedProductDto.setId(orderedProduct.getId());
        return orderedProductDto;
    }
}
