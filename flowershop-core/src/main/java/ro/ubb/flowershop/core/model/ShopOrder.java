package ro.ubb.flowershop.core.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopOrder extends BaseEntity<Integer>{

    private String date;
    private Category category;

    @OneToMany
    private Set<OrderedProduct> orderedProducts = new HashSet<>();


}
