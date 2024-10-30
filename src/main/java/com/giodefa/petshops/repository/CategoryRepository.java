package com.giodefa.petshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodefa.petshops.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
