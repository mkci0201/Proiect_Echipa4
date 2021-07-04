package ro.ubb.flowershop.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.Product;
import ro.ubb.flowershop.web.dto.ProductDto;

@Component
public class ProductConverter extends BaseConverter<Product, ProductDto> {

    @Override
    public Product convertDtoToModel(ProductDto dto) {

        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .color(dto.getColor())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .imageUrl(dto.getImageUrl())
                .build();

        product.setId(dto.getId());
        return product;
    }

    @Override
    public ProductDto convertModelToDto(Product product) {
        ProductDto productDto = new ProductDto(product.getName(), product.getDescription(),
                product.getColor(), product.getPrice(), product.getStock(), product.getImageUrl());
        productDto.setId(product.getId());
        return productDto;
    }
}
