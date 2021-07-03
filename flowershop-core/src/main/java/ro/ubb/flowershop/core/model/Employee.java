package ro.ubb.flowershop.core.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Employee extends BaseEntity<Integer>{


    @NotNull(message = "Username must be entered")
    @Size(min=3, max=30, message = "The username must be between 3 and 30 characters long")
    @Column( unique=true )
    private String username;

    @NotNull (message = "Name must be entered")
    @Size(min=3, max=30, message = "This name must be between 3 and 30 characters long")
    private String firstName, lastName;

    private EmployeeRole role;

    @NotNull
    @Pattern(regexp = "^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$", message="Introduced date is not correct")
    private String dateOfBirth;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$", message = " must contain only digits and be 10 digits long")
    private String phoneNumber;

    @NotNull
    @Size(min=6, message = "Password should have at least 6 characters")
    //@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$", message = "Password must contain one digit, one lowercase letter, one uppercase letter")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ShopOrder> shopOrders;

    @Column(name="is_inactive", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean inactive;


}
