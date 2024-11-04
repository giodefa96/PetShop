package com.giodefa.petshops.service.cart;

import java.math.BigDecimal;

import com.giodefa.petshops.model.Cart;

public interface ICartService {
    Cart getCart(Long id);
    void cleanCart(Long id);
    BigDecimal getTotalPrice(Long id);
}
