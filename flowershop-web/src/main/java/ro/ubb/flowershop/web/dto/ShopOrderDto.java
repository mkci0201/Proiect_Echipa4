package ro.ubb.flowershop.web.dto;

import lombok.*;
import ro.ubb.flowershop.core.model.Category;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShopOrderDto extends BaseDto{

    private String date;
    private Category category;
    private Set<OrderedProductDto> orderedProducts;

    @Override
    public String toString() {
        return "ShopOrderDto{" +
                " date='" + date + '\'' +
                ", category=" + category +
                ", orderedProducts=" + orderedProducts +
                '}' + super.toString();
    }
}
