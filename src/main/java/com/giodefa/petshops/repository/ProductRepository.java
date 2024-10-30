package com.giodefa.petshops.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodefa.petshops.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategoryName(String category);

    public List<Product> findByBrand(String brand);

    public List<Product> findByCategoryNameAndBrand(String category, String brand);

    public List<Product> findByName(String name);

    public List<Product> findByBrandAndName(String brand, String name);

    public Long countByBrandAndName(String brand, String name);
    
}
