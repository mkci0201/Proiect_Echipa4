package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Employee extends BaseEntity<Integer>{

    private String username;
    private String firstName, lastName;
    private EmployeeRole role;
    private String dateOfBirth, phoneNumber, password;

    //@OneToMany
    //private Set<ShopOrder> shopOrderSet;


}
