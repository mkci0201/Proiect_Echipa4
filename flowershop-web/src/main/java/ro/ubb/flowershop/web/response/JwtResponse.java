package ro.ubb.flowershop.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {

    private String token;
    private int id;
    private String type = "Basic";
    private String username;
    private String password;
    private List<String> roles;

    public JwtResponse(String token, int id, String username, String password, List<String> roles) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
