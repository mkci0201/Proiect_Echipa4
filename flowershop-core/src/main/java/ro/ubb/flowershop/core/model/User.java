package ro.ubb.flowershop.core.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends BaseEntity<Integer>{

    private  String username;
    private String password;
}
