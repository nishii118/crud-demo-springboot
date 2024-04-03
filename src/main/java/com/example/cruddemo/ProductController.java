package com.example.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    private List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    private Product getProductById(@PathVariable("productId") Long productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/products/{productId}")
    private Product updateProductById(@PathVariable("productId") Long productId, @RequestBody Product product) {
        return productService.updateProductById(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    private void deleteProductById(@PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
    }

    @PostMapping("/products")
    private Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
