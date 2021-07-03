package ro.ubb.flowershop.core.test.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ubb.flowershop.core.model.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ro.ubb.flowershop.core.model.EmployeeRole.User;

public class EmployeeTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    void createEmployee_should_setAllParametersCorrectly() {
        Employee employeeOne = new Employee("MarinaIli", "Marina","Ilitoi",User,"29march1991","123456789","MarinaIli");

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
        Employee employeeTwo = new Employee("MarinaC", "Marina","Ilitoi",User,"29march1991","123456789","MarinaIli");

        employeeTwo.setUsername("MarinaC");
        employeeTwo.setLastName("Cimpean");


        assertEquals("MarinaC", employeeTwo.getUsername());
        assertEquals("Cimpean", employeeTwo.getLastName());


    }

    @AfterEach
    public void tearDown() {

    }

}
