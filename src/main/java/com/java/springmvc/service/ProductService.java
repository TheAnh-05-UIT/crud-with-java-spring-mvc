package com.java.springmvc.service;

import org.springframework.stereotype.Service;

import com.java.springmvc.domain.Product;
import com.java.springmvc.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handleCreateProduct(Product product) {
        return this.productRepository.save(product);
    }
}
