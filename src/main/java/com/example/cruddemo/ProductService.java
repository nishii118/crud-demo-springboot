package com.example.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
//    @Autowired
//    ProductRepository productRepository;

    ArrayList<Product> products = new ArrayList<Product>();

    public ProductService() {
        products.add(new Product(1L, "Product 1"));
        products.add(new Product(2L, "Product 2"));
        products.add(new Product(3L, "Product 3"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long productId) {
        Product product = products.stream().filter(p -> p.getProductId().equals(productId)).findFirst().orElse(null);
        return product;
    }

    public Product updateProductById(Long productId, Product product) {
        Product productToUpdate = products.stream().filter(p -> p.getProductId().equals(productId)).findFirst().orElse(null);
        if (productToUpdate != null) {
            productToUpdate.setProductName(product.getProductName());
        }
        return productToUpdate;
    }

    public void deleteProductById(Long productId) {
        Product productToDelete = products.stream().filter(p -> p.getProductId().equals(productId)).findFirst().orElse(null);
        if (productToDelete != null) {
            products.remove(productToDelete);
        }
    }

    public Product createProduct(Product product) {
    products.add(product);
            return product;
    }
}
