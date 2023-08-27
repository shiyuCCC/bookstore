package com.programming3final.bookstore.service;

import java.util.List;

import com.programming3final.bookstore.entity.Book;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    List<Book> findAllAvailableBooks();

    void save(Book theBook);

    void deleteById(int theId);

}
