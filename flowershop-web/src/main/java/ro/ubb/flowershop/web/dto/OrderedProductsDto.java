package ro.ubb.flowershop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.flowershop.core.model.Order;
import ro.ubb.flowershop.core.model.Product;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderedProductsDto extends BaseDto {
    private Product product;
    private Order order;
    private int quantity;

    @Override
    public String toString() {
        return "OrderedProductsDto{" +
                "product=" + product +
                ", order=" + order +
                ", quantity=" + quantity +
                '}' + super.toString();
    }
}
