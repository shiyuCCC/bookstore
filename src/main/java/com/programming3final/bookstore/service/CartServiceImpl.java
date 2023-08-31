package com.programming3final.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.programming3final.bookstore.dao.CartRepository;
import com.programming3final.bookstore.entity.Cart;
import com.programming3final.bookstore.entity.CartInfoDTO;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository theCartRepository) {
        cartRepository = theCartRepository;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(int theId) {
        Optional<Cart> result = cartRepository.findById(theId);
        Cart theCart = null;
        if (result.isPresent()) {
            theCart = result.get();
        } else {
            throw new RuntimeException("Did not find cart id - " + theId);
        }
        return theCart;
    }

    @Override
    public void save(Cart theCart) {
        cartRepository.save(theCart);
    }

    @Override
    public void deleteById(int theId) {
        cartRepository.deleteById(theId);
    }

    @Override
    public List<CartInfoDTO> getCartInfo(String username) {
        return cartRepository.getCartInfoForUser(username);
    }

}
