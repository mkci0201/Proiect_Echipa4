package ro.ubb.flowershop.core.service;

import ro.ubb.flowershop.core.model.ShopOrder;

import java.util.List;

public interface OrderService {
    ShopOrder addOrder(ShopOrder order);
    ShopOrder updateOrder(int orderId, ShopOrder order);
    void deleteOrder(int orderId);

    ShopOrder findOne(int orderId);
    List<ShopOrder> getAllOrders();

}
