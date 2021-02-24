package io.digitalready.seller.product;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Mono<Product> postProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> putProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

}
