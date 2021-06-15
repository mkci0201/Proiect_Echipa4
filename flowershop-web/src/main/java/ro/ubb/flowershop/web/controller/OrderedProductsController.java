package ro.ubb.flowershop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.flowershop.core.model.OrderedProduct;
import ro.ubb.flowershop.core.service.OrderedProductsService;
import ro.ubb.flowershop.web.converter.OrderedProductsConverter;
import ro.ubb.flowershop.web.dto.OrderedProductDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderedProductsController {

    @Autowired
    private OrderedProductsService orderedProductsService;

    @Autowired
    private OrderedProductsConverter orderedProductsConverter;

    @RequestMapping(value = "api/orders/", method = RequestMethod.POST)
    public OrderedProductDto addOrderedProducts(@RequestBody OrderedProductDto dto) {

        OrderedProduct newOrderedProducts = orderedProductsService.addOrderedProducts(
                orderedProductsConverter.convertDtoToModel(dto)
        );

        return orderedProductsConverter.convertModelToDto(newOrderedProducts);
    }

    @RequestMapping(value = "api/orders/{orderedProductsId}", method = RequestMethod.PUT)
    public OrderedProductDto updateOrderedProducts(@PathVariable int orderedProductsId, @RequestBody OrderedProductDto dto) {
        return orderedProductsConverter.convertModelToDto(orderedProductsService.updateOrderedProducts(orderedProductsId,
                orderedProductsConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "api/orders/{orderedProductsId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrderedProducts(@PathVariable int orderedProductsId) {
        orderedProductsService.delete(orderedProductsId);

        if (orderedProductsService.getAllOrderedProducts().contains(orderedProductsId))
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "api/orders/{orderedProductsId}", method = RequestMethod.GET)
    public OrderedProductDto findOne(@PathVariable int orderedProductsId) {

        OrderedProduct orderedProducts = orderedProductsService.findOne(orderedProductsId);

        return orderedProductsConverter.convertModelToDto(orderedProducts);
    }

    @RequestMapping(value = "api/orders", method = RequestMethod.GET)
    public List<OrderedProductDto> getAllOrderedProducts() {
        List<OrderedProduct> orderedProducts = orderedProductsService.getAllOrderedProducts();

        return new ArrayList<>(orderedProductsConverter.convertModelsToDtos(orderedProducts));
    }
}
