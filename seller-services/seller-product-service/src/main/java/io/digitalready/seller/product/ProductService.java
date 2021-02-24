package io.digitalready.seller.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapping productMapping;

    public ProductService(ProductRepository productRepository, ProductMapping productMapping) {
        this.productRepository = productRepository;
        this.productMapping = productMapping;
    }

    public Flux<Product> getProducts() {
        log.info("Get all product");
        return productRepository.findAll();
    }

    public Mono<Product> getProduct(String id) {
        log.info("Get product by ID: {}", id);
        return productRepository.findById(id);
    }

    public Mono<Product> createProduct(Product product) {
        log.info("Create new product: {}", product);
        return productRepository.save(product);
    }

    public Mono<Product> updateProduct(String id, Product product) {
        log.info("Update product by ID: {}, body: {}", id, product);
        return productRepository.findById(id)
                .map(p -> productMapping.update(product, p))
                .flatMap(productRepository::save);
    }

    public Mono<Void> deleteProduct(String id) {
        log.info("Delete product by ID: {}", id);
        return productRepository.findById(id)
                .flatMap(productRepository::delete);
    }
}
