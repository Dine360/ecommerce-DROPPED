package com.ecommerce.service;

import com.ecommerce.entity.Product;
import com.ecommerce.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManagementService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductManagementService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> retrieve(){
        return productRepository.findAll();
    }
}
