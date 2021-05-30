package ro.ubb.flowershop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.OrderedProducts;
import ro.ubb.flowershop.core.service.OrderedProductsService;
import ro.ubb.flowershop.web.converter.OrderedProductsConverter;
import ro.ubb.flowershop.web.dto.EmployeeDto;
import ro.ubb.flowershop.web.dto.OrderedProductsDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrderedProductsController {

    @Autowired
    private OrderedProductsService orderedProductsService;

    @Autowired
    private OrderedProductsConverter orderedProductsConverter;

    @RequestMapping(value = "/orderedproducts/", method = RequestMethod.PUT)
    public OrderedProductsDto addOrderedProducts(@RequestBody OrderedProductsDto dto) {

        OrderedProducts newOrderedProducts = orderedProductsService.addOrderedProducts(
                orderedProductsConverter.convertDtoToModel(dto)
        );

        return orderedProductsConverter.convertModelToDto(newOrderedProducts);
    }

    @RequestMapping(value = "/orderedproducts/{orderedProductsId}", method = RequestMethod.PUT)
    public OrderedProductsDto updateOrderedProducts(@PathVariable int orderedProductsId, @RequestBody OrderedProductsDto dto) {
        return orderedProductsConverter.convertModelToDto(orderedProductsService.updateOrderedProducts(orderedProductsId,
                orderedProductsConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "/orderedproducts/{orderedProductsId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrderedProducts(@PathVariable int orderedProductsId) {
        orderedProductsService.delete(orderedProductsId);

        if (orderedProductsService.getAllOrderedProducts().contains(orderedProductsId))
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/orderedproducts/{orderedProductsId}", method = RequestMethod.GET)
    public OrderedProductsDto findOne(@PathVariable int orderedProductsId) {

        OrderedProducts orderedProducts = orderedProductsService.findOne(orderedProductsId);

        return orderedProductsConverter.convertModelToDto(orderedProducts);
    }

    @RequestMapping(value = "/orderedproducts", method = RequestMethod.GET)
    public List<OrderedProductsDto> getAllOrderedProducts() {
        List<OrderedProducts> orderedProducts = orderedProductsService.getAllOrderedProducts();

        return new ArrayList<>(orderedProductsConverter.convertModelsToDtos(orderedProducts));
    }
}
