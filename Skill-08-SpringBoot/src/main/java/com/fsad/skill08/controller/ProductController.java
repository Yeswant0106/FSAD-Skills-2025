package com.fsad.skill08.controller;

import com.fsad.skill08.model.Product;
import com.fsad.skill08.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Add Product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // Get products by category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getProductsByCategory(category);
    }

    // Filter by price range
    @GetMapping("/filter")
    public List<Product> filterByPrice(
            @RequestParam double min,
            @RequestParam double max) {

        return service.getProductsByPriceRange(min, max);
    }

    // Sort by price
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return service.getSortedProducts();
    }

    // Products above price
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }
}
