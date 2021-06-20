package ro.ubb.flowershop.core.service;

import org.springframework.stereotype.Service;
import ro.ubb.flowershop.core.model.OrderedProduct;

import java.util.List;

@Service
public interface OrderedProductsService {

    OrderedProduct addOrderedProducts(OrderedProduct orderedProduct);
    OrderedProduct updateOrderedProducts(int orderedProductsId, OrderedProduct orderedProduct);
    void delete(int orderedProductsId);
    OrderedProduct findOne(int orderedProductsId);

    List<OrderedProduct> getAllOrderedProducts();
    List<OrderedProduct> getBestSellingProducts();
}
