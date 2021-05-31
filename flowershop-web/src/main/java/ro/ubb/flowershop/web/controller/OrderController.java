package ro.ubb.flowershop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.flowershop.core.model.Order;
import ro.ubb.flowershop.core.service.OrderService;
import ro.ubb.flowershop.web.converter.OrderConverter;
import ro.ubb.flowershop.web.dto.OrderDto;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderConverter orderConverter;

    @RequestMapping(value = "/orders/", method = RequestMethod.PUT)
    public OrderDto addOrder(@RequestBody OrderDto dto) {

        Order newOrder = orderService.addOrder(
                orderConverter.convertDtoToModel(dto)
        );

        return orderConverter.convertModelToDto(newOrder);
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.PUT)
    public OrderDto updateOrder(@PathVariable int orderId, @RequestBody OrderDto dto){
        return orderConverter.convertModelToDto(orderService
                .updateOrder(orderId, orderConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@PathVariable int orderId){

        orderService.deleteOrder(orderId);

        if(orderService.getAllOrders().contains(orderId)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }else
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public OrderDto findOne(@PathVariable int orderId){

        Order order = orderService.findOne(orderId);

        return orderConverter.convertModelToDto(order);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<OrderDto> getAllOrders() {

        List<Order> orders = orderService.getAllOrders();

        return new ArrayList<>(orderConverter.convertModelsToDtos(orders));
    }

}

