package com.programming3final.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programming3final.bookstore.service.BookService;
import com.programming3final.bookstore.service.CartService;
import com.programming3final.bookstore.service.UserService;

import jakarta.validation.Valid;

import com.programming3final.bookstore.entity.Book;
import com.programming3final.bookstore.entity.Cart;
import com.programming3final.bookstore.entity.CartInfoDTO;
import com.programming3final.bookstore.entity.User;

@Controller
@RequestMapping("/cart")
public class CartController {

    public CartService cartService;
    public BookService bookService;
    public UserService userService;

    public CartController(CartService theCartService, BookService theBookService, UserService theUserService) {
        cartService = theCartService;
        bookService = theBookService;
        userService = theUserService;
    }

    @PostMapping("/save")
    public String saveCart(@Valid @ModelAttribute("cart") Cart theCart,
            BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "books/shopping-list";
        } else {
            System.out.println("Cart Contents:");
            System.out.println("Book ID: " + theCart.getBook().getId());
            System.out.println("Quantity: " + theCart.getQuantity());
            System.out.println("Buyer: " + theCart.getBuyer());

            cartService.save(theCart);
            return "redirect:/cart/cartInfoByUser?username=" + theCart.getBuyer();
        }
    }

    // @PostMapping("/save")
    // public String addToCart(@ModelAttribute("cart") Cart cart) {
    // // Retrieve the Book and User entities based on the IDs and buyerName
    // Book book = bookService.findById(cart.getBook().getId());
    // User buyer = userService.findByUsername(cart.getBuyer().getUsername());

    // // Set the retrieved Book and User in the cart
    // cart.setBook(book);
    // cart.setBuyer(buyer);

    // // Save the cart to the database
    // cartService.save(cart);

    // return "books/shopping-list"; // Redirect to a relevant page after adding to
    // cart
    // }

    @GetMapping("/cartInfoByUser")
    public String findByUsername(@RequestParam("username") String theUsername, Model theModel) {
        List<CartInfoDTO> theCarts = cartService.getCartInfo(theUsername);
        theModel.addAttribute("cartsInfo", theCarts);
        return "carts/showCart";
    }

    @GetMapping("/delete")
    public String deleteCart(@RequestParam("cartId") int theCartId, @RequestParam("username") String theUsername) {
        cartService.deleteById(theCartId);
        return "redirect:/cart/cartInfoByUser?username=" + theUsername;
    }

}
