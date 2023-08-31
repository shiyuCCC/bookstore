package com.programming3final.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.programming3final.bookstore.entity.Book;
import com.programming3final.bookstore.entity.Cart;
import com.programming3final.bookstore.entity.User;
import com.programming3final.bookstore.service.BookService;
import com.programming3final.bookstore.service.UserService;

import jakarta.validation.Valid;

@Controller
// @RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private UserService userService;

    public BookController(BookService theBookService, UserService theUserService) {
        bookService = theBookService;
        userService = theUserService;
    }

    @GetMapping("/")
    public String listAvailableBook(Model theModel) {
        List<Book> theBooks = bookService.findAllAvailableBooks();
        theModel.addAttribute("availableBooks", theBooks);
        return "home";
    }

    @GetMapping("/staff/list")
    public String listBookInventory(Model theModel) {
        List<Book> theBooks = bookService.findAll();

        theModel.addAttribute("books", theBooks);
        return "books/inventory-book";
    }

    @GetMapping("/staff/showFormForAdd")
    public String showForm(Model theModel) {
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);
        return "books/form-book";
    }

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "redirect:staff/showFormForAdd";
        } else {
            bookService.save(theBook);
            return "redirect:staff/list";
        }
    }

    @GetMapping("/staff/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
        Book theBook = bookService.findById(theId); // use book entity and JPA
        theModel.addAttribute("book", theBook);
        return "books/form-book";

    }

    @GetMapping("/showProductDetails")
    public String showProductDetails(@RequestParam("bookId") int theId, @RequestParam("username") String theUsername,
            Model theModel) {
        System.out.println("The username:" + theUsername);

        Book theBook = bookService.findById(theId);
        // User theUser = userService.findByUsername(theUsername);
        // System.out.println("The user:" + theUser);
        // User theUser = new User();
        Cart theCart = new Cart();
        theCart.setBook(theBook);
        theCart.setBuyer(theUsername);
        theModel.addAttribute("book", theBook);
        theModel.addAttribute("cart", theCart);
        return "books/product-details";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {
        bookService.deleteById(theId);
        return "redirect:staff/list";
    }

}
