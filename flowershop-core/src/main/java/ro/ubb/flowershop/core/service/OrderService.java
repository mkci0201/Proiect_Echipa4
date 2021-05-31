package ro.ubb.flowershop.core.service;

import ro.ubb.flowershop.core.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    Order updateOrder(int orderId, Order order);
    void deleteOrder(int orderId);

    Order findOne(int orderId);
    List<Order> getAllOrders();

}
