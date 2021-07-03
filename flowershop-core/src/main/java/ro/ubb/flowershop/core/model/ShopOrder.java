package ro.ubb.flowershop.core.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @NotNull
    @Pattern(regexp = "^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$", message="Introduced date is not correct")
    private String date;

    private Category category;

    @OneToMany(cascade = CascadeType.MERGE, fetch= FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "shop_order_id")
    private Set<OrderedProduct> orderedProducts;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;



}
