package ro.ubb.flowershop.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.model.Product;
import ro.ubb.flowershop.core.service.ProductService;
import ro.ubb.flowershop.web.converter.ProductConverter;
import ro.ubb.flowershop.web.dto.EmployeeDto;
import ro.ubb.flowershop.web.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @RequestMapping(value = "api/products", method = RequestMethod.POST)
    public ProductDto addProduct(@RequestBody ProductDto dto) {

        Product newProduct = productService.addProduct(
                productConverter.convertDtoToModel(dto)
        );

        return productConverter.convertModelToDto(newProduct);
    }

    @RequestMapping(value = "api/products/{productId}", method = RequestMethod.PUT)
    public ProductDto updateProduct(@PathVariable int productId, @RequestBody ProductDto dto){
        return productConverter.convertModelToDto(productService
        .updateProducts(productId, productConverter.convertDtoToModel(dto)));
    }

    @RequestMapping(value = "api/products/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable int productId){

        productService.deleteProduct(productId);

        if(productService.getAllProducts().contains(productId)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }else
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "api/products/{productId}", method = RequestMethod.GET)
    public ProductDto findOne(@PathVariable int productId){

        Product product = productService.findOne(productId);

        return productConverter.convertModelToDto(product);
    }

    @RequestMapping(value = "api/products", method = RequestMethod.GET)
    public List<ProductDto> getAllProducts() {

        List<Product> products = productService.getAllProducts();

        return new ArrayList<>(productConverter.convertModelsToDtos(products));
    }
}
