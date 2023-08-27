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
import com.programming3final.bookstore.entity.Book;
import com.programming3final.bookstore.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/list")
    public String listBookInventory(Model theModel) {
        List<Book> theBooks = bookService.findAll();

        theModel.addAttribute("books", theBooks);
        return "books/inventory-book";
    }

    @GetMapping("/shoppingList")
    public String listAvailableBook(Model theModel) {
        List<Book> theBooks = bookService.findAllAvailableBooks();
        theModel.addAttribute("availableBooks", theBooks);
        return "books/shopping-list";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel) {
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);
        return "books/form-book";
    }

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "books/form-book";
        } else {
            bookService.save(theBook);
            return "redirect:/books/inventory-book";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
        Book theBook = bookService.findById(theId); // use book entity and JPA
        theModel.addAttribute("book", theBook);
        return "books/form-book";

    }

    @GetMapping("/showProductDetails")
    public String showProductDetails(@RequestParam("bookId") int theId, Model theModel) {
        Book theBook = bookService.findById(theId);
        theModel.addAttribute("book", theBook);
        return "/books/product-details";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {
        bookService.deleteById(theId);
        return "redirect:/books/inventory-book";
    }

}
