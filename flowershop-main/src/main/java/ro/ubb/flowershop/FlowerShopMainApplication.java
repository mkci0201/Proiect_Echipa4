package ro.ubb.flowershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication(scanBasePackages = "ro.ubb.flowershop.web.controller")
@SpringBootApplication(scanBasePackages = {"ro.ubb.flowershop.core", "ro.ubb.flowershop" })
public class FlowerShopMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerShopMainApplication.class, args);
    }

}
