package ro.ubb.flowershop.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.Product;
import ro.ubb.flowershop.web.dto.ProductDto;

@Component
public class ProductConverter extends BaseConverter<Product, ProductDto> {

    @Override
    public Product convertDtoToModel(ProductDto dto) {
        Product product=new Product(dto.getName(), dto.getDescription(), dto.getColor(), dto.getPrice(), dto.getStock());
        dto.setId(dto.getId());
        return product;
    }

    @Override
    public ProductDto convertModelToDto(Product product) {
        ProductDto productDto = new ProductDto(product.getName(), product.getDescription(),
                product.getColor(), product.getPrice(), product.getStock());
        productDto.setId(product.getId());
        return productDto;
    }
}
