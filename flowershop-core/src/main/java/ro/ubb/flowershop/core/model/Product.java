package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.Entity;
import java.awt.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Product extends BaseEntity<Integer>{

    private String name;
    private String description;
    private ProductColor color;
    private double price;
    private int stock;


}
