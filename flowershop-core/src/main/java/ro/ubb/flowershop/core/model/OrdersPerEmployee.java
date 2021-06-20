package ro.ubb.flowershop.core.model;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrdersPerEmployee {

    private Employee employee;
    private int count;
    private double totalPrice;
}
