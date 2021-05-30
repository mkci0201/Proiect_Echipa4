package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderedProducts extends BaseEntity<Integer>{

    @Id
    @ManyToOne(optional = false)
    private Product product;

    @Id
    @ManyToOne(optional = false)
    private Order order;

    private int quantity;

}
