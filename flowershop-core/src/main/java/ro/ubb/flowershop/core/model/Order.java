package ro.ubb.flowershop.core.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Order extends BaseEntity<Integer>{

    @ManyToOne
    private Employee employee;
    private String date;
    private Category category;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderedProducts> orderedProducts = new HashSet<>();

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(orderedProducts.stream()
                .map(OrderedProducts :: getProduct).collect(Collectors.toSet()));
    }

}
