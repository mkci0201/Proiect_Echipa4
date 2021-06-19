package ro.ubb.flowershop.web.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.User;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @RequestMapping(value="/api/login", method = RequestMethod.POST)
    public boolean login(@RequestBody User user) {
        //return true;
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }

    @RequestMapping("api/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
}
