package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderedProduct extends BaseEntity<Integer>{

    @ManyToOne(optional = false)
    private Product product;

    private int quantity;

}
