package ro.ubb.flowershop.core.test.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ubb.flowershop.core.model.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ro.ubb.flowershop.core.model.EmployeeRole.User;

public class EmployeeTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    void createEmployee_should_setAllParametersCorrectly() {
        Set<ShopOrder> shoporders = new HashSet<>();
        Set<OrderedProduct> orderedProducts = new HashSet<>();
        Product product = new Product("rose", "asdasd", ProductColor.Black, 1.7, 23, false);
        OrderedProduct orderedProduct = new OrderedProduct(product, 1);
        Employee employeeOne = new Employee("MarinaIli", "Marina","Ilitoi",User,"29march1991","123456789","MarinaIli", shoporders, false);

        ShopOrder shopOrder = new ShopOrder("2021-06-29", Category.Bouquets, orderedProducts, employeeOne);

        assertEquals("MarinaIli", employeeOne.getUsername());
        assertEquals("Marina", employeeOne.getFirstName());
        assertEquals("Ilitoi", employeeOne.getLastName());
        assertEquals("29march1991", employeeOne.getDateOfBirth());
        assertEquals(User, employeeOne.getRole());
        assertEquals("123456789", employeeOne.getPhoneNumber());
        assertEquals("MarinaIli", employeeOne.getPassword());

    }
    @Test
    void EmployeeObject_should_changeAllNewParameters() {
        Set<ShopOrder> shoporders = new HashSet<>();
        Set<OrderedProduct> orderedProducts = new HashSet<>();
        Product product = new Product("rose", "asdasd", ProductColor.Black, 1.7, 23, false);
        OrderedProduct orderedProduct = new OrderedProduct(product, 1);
        Employee employeeTwo = new Employee("MarinaC", "Marina","Ilitoi",User,"29march1991","123456789","MarinaIli", shoporders, false);

        ShopOrder shopOrder = new ShopOrder("2021-06-29", Category.Bouquets, orderedProducts, employeeTwo);


        employeeTwo.setUsername("MarinaC");
        employeeTwo.setLastName("Cimpean");


        assertEquals("MarinaC", employeeTwo.getUsername());
        assertEquals("Cimpean", employeeTwo.getLastName());


    }

    @AfterEach
    public void tearDown() {

    }

}
