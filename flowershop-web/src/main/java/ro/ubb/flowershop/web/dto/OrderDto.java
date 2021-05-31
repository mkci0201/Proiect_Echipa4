package ro.ubb.flowershop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.flowershop.core.model.Category;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto extends BaseDto{

    private EmployeeDto employeeDto;
    private String date;
    private Category category;

    @Override
    public String toString() {
        return "OrderDto{" +
                "employeeDto=" + employeeDto +
                ", date='" + date + '\'' +
                ", category=" + category +
                '}' + super.toString();
    }
}
