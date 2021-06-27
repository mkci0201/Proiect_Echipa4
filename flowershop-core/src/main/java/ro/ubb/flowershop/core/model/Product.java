package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Product extends BaseEntity<Integer>{

    @NotNull(message = "Name must be entered")
    @Size(min=3, max=30, message = "The name '${validatedValue}' must be between {min} and {max} characters long")
    private String name;

    @Size(max=50, message = "Description should not surpass 50 characters")
    private String description;

    private ProductColor color;

    @NotNull(message = "Price must be entered")
    @Positive(message="Price must be positive and different from 0")
    private double price;

    @NotNull(message = "Stock must be entered")
    @PositiveOrZero(message="Stock must be positive")
    private int stock;

}
