package ro.ubb.flowershop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.flowershop.core.model.EmployeeRole;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto extends BaseDto{

    private String username;
    private String firstName, lastName;
    private EmployeeRole role;
    private String dateOfBirth, phoneNumber, password;



    @Override
    public String toString() {
        return "EmployeeDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}' + super.toString();
    }
}
