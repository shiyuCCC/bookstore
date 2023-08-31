package com.programming3final.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.programming3final.bookstore.entity.Cart;
import com.programming3final.bookstore.entity.CartInfoDTO;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("SELECT new com.programming3final.bookstore.entity.CartInfoDTO(c.id as cartId, b.title as bookTitle, " +
            "b.author as bookAuthor, b.image_url as bookImage, b.price as bookPrice, c.quantity as bookQuantity, " +
            "c.buyer as buyerUsername) " +
            "FROM Cart c " +
            "JOIN Book b ON c.book.id = b.id " +
            "WHERE c.buyer = :username")
    List<CartInfoDTO> getCartInfoForUser(@Param("username") String username);
}
