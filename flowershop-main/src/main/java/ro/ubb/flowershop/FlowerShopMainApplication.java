package ro.ubb.flowershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ro.ubb.flowershop")
public class FlowerShopMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerShopMainApplication.class, args);
    }
}
