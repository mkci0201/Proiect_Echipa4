package ro.ubb.flowershop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.core.model.Product;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderedProductDto extends BaseDto {
    private ProductDto product;
    private int quantity;

    @Override
    public String toString() {
        return "OrderedProductDto{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
