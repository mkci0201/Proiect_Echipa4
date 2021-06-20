package ro.ubb.flowershop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.flowershop.core.model.ProductColor;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.core.model.Product;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto extends BaseDto {

    private String name;
    private String description;
    private ProductColor color;
    private double price;
    private int stock;

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color=" + color +
                ", price=" + price +
                ", stock=" + stock +
                '}' + super.toString();
    }
}
