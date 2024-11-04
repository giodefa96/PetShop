package com.giodefa.petshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodefa.petshops.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
