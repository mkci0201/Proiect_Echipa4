package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderedProduct extends BaseEntity<Integer>{

    @OneToOne
    private Product product;

    @NotNull(message = "Quantity must be entered")
    @Positive(message="Quantity must be positive and different from 0")
    private int quantity;

}
