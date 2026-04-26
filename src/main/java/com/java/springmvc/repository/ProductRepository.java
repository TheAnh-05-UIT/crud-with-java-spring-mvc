package com.java.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springmvc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
