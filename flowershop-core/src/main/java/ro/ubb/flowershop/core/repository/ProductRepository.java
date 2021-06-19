package ro.ubb.flowershop.core.repository;

import ro.ubb.flowershop.core.model.Product;
import ro.ubb.flowershop.core.model.ProductColor;

import java.util.List;

public interface ProductRepository extends FlowerShopRepository<Product, Integer> {

    List<Product> findProductByColor(ProductColor color);

}