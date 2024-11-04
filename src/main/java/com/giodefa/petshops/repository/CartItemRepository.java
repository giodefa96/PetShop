package com.giodefa.petshops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giodefa.petshops.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long id);
}
