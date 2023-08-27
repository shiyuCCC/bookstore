package com.programming3final.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming3final.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
