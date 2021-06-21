package ro.ubb.flowershop.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Basic";
    private String username;
    private String password;


    public JwtResponse(String token, String username, String password) {
        this.token = token;
        this.username = username;
        this.password = password;
    }
}
