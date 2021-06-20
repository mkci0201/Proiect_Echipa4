package ro.ubb.flowershop.core.repository;

import ro.ubb.flowershop.core.model.ShopOrder;

import java.util.List;

public interface OrderRepository extends FlowerShopRepository<ShopOrder, Integer>{

        List<ShopOrder> findShopOrdersByEmployee_Id(int employeeId);
    }



