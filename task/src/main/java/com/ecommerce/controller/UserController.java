package com.ecommerce.controller;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private Map<String, String> buyerCredentials = new HashMap<>(); // Map to store buyer credentials

    @Autowired
    private ProductManagementService productService;

    @GetMapping("/test")
    public String getRestStatus() {
        return "Working!";
    }

    // Endpoint to get all product lists
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.retrieve();
    }
}
