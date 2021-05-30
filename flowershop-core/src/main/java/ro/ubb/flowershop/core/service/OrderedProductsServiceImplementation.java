package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.flowershop.core.model.OrderedProducts;
import ro.ubb.flowershop.core.repository.OrderedProductsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderedProductsServiceImplementation implements OrderedProductsService {

    @Autowired
    private OrderedProductsRepository orderedProductsRepository;

    @Override
    public OrderedProducts addOrderedProducts(OrderedProducts orderedProducts) {
        OrderedProducts newOrderedProducts = orderedProductsRepository.save(orderedProducts);
        return newOrderedProducts;
    }

    @Override
    @Transactional
    public OrderedProducts updateOrderedProducts(int orderedProductsId, OrderedProducts orderedProducts) {

        Optional<OrderedProducts> uOrderedProducts = orderedProductsRepository.findById(orderedProductsId);

        uOrderedProducts.ifPresent(e->{
            e.setProduct(orderedProducts.getProduct());
            e.setOrder(orderedProducts.getOrder());
            e.setQuantity(orderedProducts.getQuantity());
        });

        return uOrderedProducts.orElse(null);
    }

    @Override
    public void delete(int orderedProductsId) {
        orderedProductsRepository.deleteById(orderedProductsId);
    }

    @Override
    public OrderedProducts findOne(int orderedProductsId) {
        OrderedProducts orderedProducts = orderedProductsRepository.findById(orderedProductsId).orElseThrow();
        return orderedProducts;
    }

    @Override
    public List<OrderedProducts> getAllOrderedProducts() {
        return orderedProductsRepository.findAll();
    }
}
