package com.ecommerce.Service;

import com.ecommerce.Entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManagementService {
    private Map<String, Product> products = new HashMap<>(); // Simulated product database

    public Product getProductById(String productId) {
        return products.get(productId);
    }

    public void updateProduct(Product product) {
        products.put(product.getId(), product);
    }
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
}
