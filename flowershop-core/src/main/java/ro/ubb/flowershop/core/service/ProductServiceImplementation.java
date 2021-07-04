package ro.ubb.flowershop.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.flowershop.core.model.Product;
import ro.ubb.flowershop.core.model.ProductColor;
import ro.ubb.flowershop.core.repository.ProductRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {

        Product newProduct= productRepository.save(product);
        return newProduct;
    }

    @Override
    @Transactional
    public Product updateProducts(int productId, Product product) {

        Optional<Product> uProduct = productRepository.findById(productId);

        uProduct.ifPresent(e->{
            e.setName(product.getName());
            e.setDescription(product.getDescription());
            e.setColor(product.getColor());
            e.setPrice(product.getPrice());
            e.setStock(product.getStock());
            e.setImageUrl(product.getImageUrl());
        });

        return uProduct.orElse(null);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {

        Optional<Product> productWithdrawn = productRepository.findById(productId);
        productWithdrawn.ifPresent( p -> {
            p.setWithdrawn(true);
        });

    }

    @Override
    public Product findOne(int productId) {

        Product product = productRepository.findById(productId).orElseThrow();

        if (product != null && !product.isWithdrawn()){
            return product;
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll().stream()
                                .filter(p -> p.isWithdrawn() == false).collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllAvailableProductsPerColor(ProductColor color){
        return productRepository.findProductByColor(color)
                                .stream()
                                .filter(product ->  product.isWithdrawn() == false && product.getStock() >= 0)
                                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllAvailableProducts() {

                return productRepository.findAll()
                                 .stream()
                                 .filter(product -> product.isWithdrawn() == false && product.getStock() > 0)
                                 .collect(Collectors.toList());
    }
}
