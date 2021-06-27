package ro.ubb.flowershop.core.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
//    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$", message="Introduced date is not correct")
    private String date;

    private Category category;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<OrderedProduct> orderedProducts;

    @ManyToOne
    private Employee employee;



}
