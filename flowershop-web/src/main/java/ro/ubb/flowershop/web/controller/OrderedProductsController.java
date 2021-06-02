package ro.ubb.flowershop.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class OrderedProductsController {

    /*@Autowired
    private OrderedProductsService orderedProductsService;

    @Autowired
    private OrderedProductsConverter orderedProductsConverter;

    @RequestMapping(value = "/orderedproducts/", method = RequestMethod.PUT)
    public OrderedProductDto addOrderedProducts(@RequestBody OrderedProductDto dto) {

        OrderedProduct newOrderedProducts = orderedProductsService.addOrderedProducts(
                orderedProductsConverter.convertDtoToModel(dto)
        );

        return orderedProductsConverter.convertModelToDto(newOrderedProducts);
    }

    @RequestMapping(value = "/orderedproducts/{orderedProductsId}", method = RequestMethod.PUT)
    public OrderedProductDto updateOrderedProducts(@PathVariable int orderedProductsId, @RequestBody OrderedProductDto dto) {
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
    public OrderedProductDto findOne(@PathVariable int orderedProductsId) {

        OrderedProduct orderedProducts = orderedProductsService.findOne(orderedProductsId);

        return orderedProductsConverter.convertModelToDto(orderedProducts);
    }

    @RequestMapping(value = "/orderedproducts", method = RequestMethod.GET)
    public List<OrderedProductDto> getAllOrderedProducts() {
        List<OrderedProduct> orderedProducts = orderedProductsService.getAllOrderedProducts();

        return new ArrayList<>(orderedProductsConverter.convertModelsToDtos(orderedProducts));
    }*/
}
