package ro.ubb.flowershop.core.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopOrder extends BaseEntity<Integer>{

    private String date;
    private Category category;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<OrderedProduct> orderedProducts;

    @ManyToOne
    private Employee employee;



}
