package ro.ubb.flowershop.core.repository;

import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.EmployeeRole;
import ro.ubb.flowershop.core.model.ShopOrder;

import javax.persistence.criteria.SetJoin;
import java.util.List;

public interface EmployeeRepository extends FlowerShopRepository<Employee, Integer>{


        List<Employee> findAllByRole(EmployeeRole role);
        Employee findByUsername(String username);


}
