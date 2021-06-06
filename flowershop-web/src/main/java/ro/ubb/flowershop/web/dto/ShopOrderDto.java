package ro.ubb.flowershop.web.dto;

import lombok.*;
import ro.ubb.flowershop.core.model.Category;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShopOrderDto extends BaseDto{

    private String date;
    private Category category;

    @Override
    public String toString() {
        return "ShopOrderDto{" +
                " date='" + date + '\'' +
                ", category=" + category +
                '}' + super.toString();
    }
}
