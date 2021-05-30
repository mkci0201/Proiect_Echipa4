package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Employee extends BaseEntity<Integer>{

    private String username;
    private String firstName, lastName;
    private EmployeeRole role;
    private String dateOfBirth, phoneNumber, password;

    //@ManyToOne
    //private Order order;

}
