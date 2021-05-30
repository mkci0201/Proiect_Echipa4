package ro.ubb.flowershop.core.service;

import ro.ubb.flowershop.core.model.OrderedProducts;

import java.util.List;

public interface OrderedProductsService {

    OrderedProducts addOrderedProducts(OrderedProducts orderedProducts);
    OrderedProducts updateOrderedProducts(int orderedProductsId, OrderedProducts orderedProducts);
    void delete(int orderedProductsId);
    OrderedProducts findOne(int orderedProductsId);

    List<OrderedProducts> getAllOrderedProducts();
}
