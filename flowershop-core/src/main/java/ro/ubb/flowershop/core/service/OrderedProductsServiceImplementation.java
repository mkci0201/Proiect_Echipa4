package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.flowershop.core.model.OrderedProduct;
import ro.ubb.flowershop.core.repository.OrderedProductsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class OrderedProductsServiceImplementation implements OrderedProductsService {

    @Autowired
    private OrderedProductsRepository orderedProductsRepository;

    @Override
    public OrderedProduct addOrderedProducts(OrderedProduct orderedProduct) {
        OrderedProduct newOrderedProduct = orderedProductsRepository.save(orderedProduct);
        return newOrderedProduct;
    }

    @Override
    @Transactional
    public OrderedProduct updateOrderedProducts(int orderedProductsId, OrderedProduct orderedProduct) {

        Optional<OrderedProduct> uOrderedProducts = orderedProductsRepository.findById(orderedProductsId);

        /*uOrderedProducts.ifPresent(e->{
            e.setProduct(orderedProduct.getProduct());
            e.setShopOrder(orderedProduct.getShopOrder());
            e.setQuantity(orderedProduct.getQuantity());
        });*/

        return uOrderedProducts.orElse(null);
    }

    @Override
    public void delete(int orderedProductsId) {
        orderedProductsRepository.deleteById(orderedProductsId);
    }

    @Override
    public OrderedProduct findOne(int orderedProductsId) {
        OrderedProduct orderedProduct = orderedProductsRepository.findById(orderedProductsId).orElseThrow();
        return orderedProduct;
    }

    @Override
    public List<OrderedProduct> getAllOrderedProducts() {
        return orderedProductsRepository.findAll();
    }
}
