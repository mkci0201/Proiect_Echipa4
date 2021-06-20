package ro.ubb.flowershop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.flowershop.core.model.ShopOrder;
import ro.ubb.flowershop.core.service.OrderService;
import ro.ubb.flowershop.web.converter.ShopOrderConverter;
import ro.ubb.flowershop.web.dto.ShopOrderDto;


import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShopOrderConverter orderConverter;

    @RequestMapping(value = "api/shoporders", method = RequestMethod.POST)
    public ShopOrderDto addOrder(@RequestBody ShopOrderDto dto) {

        ShopOrder newOrder = orderService.addOrder(
                orderConverter.convertDtoToModel(dto)
        );

        return orderConverter.convertModelToDto(newOrder);
    }

    @RequestMapping(value = "api/shoporders/{orderId}", method = RequestMethod.PUT)
    public ShopOrderDto updateOrder(@PathVariable int orderId, @RequestBody ShopOrderDto dto){
        return orderConverter.convertModelToDto(orderService
                .updateOrder(orderId, orderConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "api/shoporders/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@PathVariable int orderId){

        orderService.deleteOrder(orderId);

        if(orderService.getAllOrders().contains(orderId)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }else
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "api/shoporders/{orderId}", method = RequestMethod.GET)
    public ShopOrderDto findOne(@PathVariable int orderId){

        ShopOrder order = orderService.findOne(orderId);

        return orderConverter.convertModelToDto(order);
    }

    @RequestMapping(value = "api/shoporders", method = RequestMethod.GET)
    public List<ShopOrderDto> getAllOrders() {

        List<ShopOrder> orders = orderService.getAllOrders();

        return new ArrayList<>(orderConverter.convertModelsToDtos(orders));
    }

}

