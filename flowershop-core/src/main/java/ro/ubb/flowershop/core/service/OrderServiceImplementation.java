package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.core.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ShopOrder addOrder(ShopOrder order) {

        ShopOrder newOrder = orderRepository.save(order);
        return newOrder;
    }

    @Override
    @Transactional
    public ShopOrder updateOrder(int orderId, ShopOrder order){

        Optional<ShopOrder> uOrder = orderRepository.findById(orderId);

        uOrder.ifPresent(e->{
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
    public ShopOrder findOne(int orderId) {

        ShopOrder order = orderRepository.findById(orderId).orElseThrow();
        return order;
    }

    @Override
    public List<ShopOrder> getAllOrders() {

        return orderRepository.findAll();
    }

    @Override
    public List<ShopOrder> getShopOrdersPerEmployee(int employeeId){

        return orderRepository.findShopOrdersByEmployee_Id(employeeId);
    }
}
