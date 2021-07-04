package ro.ubb.flowershop.core.test.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ubb.flowershop.core.model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ro.ubb.flowershop.core.model.ProductColor.*;

public class ProductTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    void createProduct_should_setAllParametersCorrectly() {
        Product productOne = new Product("Trandafir","rosu patat",Red,200.00,100, false, "Url");

        assertEquals("Trandafir", productOne.getName());
        assertEquals("rosu patat", productOne.getDescription());
        assertEquals(Red, productOne.getColor());
        assertEquals(200.00, productOne.getPrice());
        assertEquals(100, productOne.getStock());
    }
    @Test
    void ProductObject_should_changeAllNewParameters() {
        Product productTwo = new Product("Liliac","mov",Purple,100.00,10, false, "Url");

        productTwo.setName("Liliac");
        productTwo.setDescription("alb");
        productTwo.setColor(White);


        assertEquals("Liliac", productTwo.getName());
        assertEquals("alb", productTwo.getDescription());
        assertEquals(White, productTwo.getColor());


    }

    @AfterEach
    public void tearDown() {

    }

}
