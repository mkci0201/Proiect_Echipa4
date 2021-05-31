package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.flowershop.core.model.Order;
import ro.ubb.flowershop.core.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {

        Order newOrder = orderRepository.save(order);
        return newOrder;
    }

    @Override
    @Transactional
    public Order updateOrder(int orderId, Order order){

        Optional<Order> uOrder = orderRepository.findById(orderId);

        uOrder.ifPresent(e->{
            e.setEmployee(order.getEmployee());
            e.setDate(order.getDate());
            e.setCategory(order.getCategory());
        });

        return uOrder.orElse(null);
    }


    @Override
    public void deleteOrder(int orderId) {

        orderRepository.deleteById(orderId);


    }

    @Override
    public Order findOne(int orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow();
        return order;
    }

    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }
}
