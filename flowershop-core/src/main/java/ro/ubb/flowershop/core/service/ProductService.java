package ro.ubb.flowershop.core.service;

import org.springframework.stereotype.Service;
import ro.ubb.flowershop.core.model.Product;

import java.util.List;

@Service
public interface ProductService {

    Product addProduct(Product product);
    Product updateProducts(int productId, Product product);
    void deleteProduct (int productId);

    Product findOne(int productId);
    List<Product> getAllProducts();
}
