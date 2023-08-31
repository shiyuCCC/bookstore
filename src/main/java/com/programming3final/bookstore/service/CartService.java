package com.programming3final.bookstore.service;

import java.util.List;

import com.programming3final.bookstore.entity.Cart;
import com.programming3final.bookstore.entity.CartInfoDTO;

public interface CartService {
    List<Cart> findAll();

    Cart findById(int theId);

    void save(Cart theCart);

    void deleteById(int theId);

    List<CartInfoDTO> getCartInfo(String username);

    void deleteAllByIdIn(List<Integer> itemIds);
}
