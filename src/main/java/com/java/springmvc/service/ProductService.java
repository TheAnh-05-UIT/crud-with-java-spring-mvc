package com.java.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.springmvc.domain.Product;
import com.java.springmvc.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> handleGetAllProduct() {
        return this.productRepository.findAll();
    }

    public Product handleCreateProduct(Product product) {
        return this.productRepository.save(product);
    }
}
