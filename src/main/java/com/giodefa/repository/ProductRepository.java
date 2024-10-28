package com.giodefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodefa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
