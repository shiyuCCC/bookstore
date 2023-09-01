package com.programming3final.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.programming3final.bookstore.service.BookService;
import com.programming3final.bookstore.service.CartService;
import com.programming3final.bookstore.service.UserService;

import jakarta.validation.Valid;

import com.programming3final.bookstore.entity.Cart;
import com.programming3final.bookstore.entity.CartInfoDTO;

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

    @PostMapping("/pay")
    public String processPayment(@RequestParam("itemIds") List<Integer> itemIds,
            @RequestParam("username") String theUsername, Model theModel) {
        List<CartInfoDTO> theCartsInfo = cartService.getCartInfo(theUsername);
        theModel.addAttribute("cartsInfo", theCartsInfo);
        cartService.deleteAllByIdIn(itemIds);
        return "carts/paymentConfirm";
    }

}
