package com.programming3final.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    // fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "buyer")
    private String buyer;

    @Column(name = "quantity")
    private int quantity;

    // Constructor

    public Cart() {
    }

    public Cart(int id, Book book, String buyer, int quantity) {
        this.id = id;
        this.book = book;
        this.buyer = buyer;
        this.quantity = quantity;
    }

    public Cart(Book book, String buyer, int quantity) {
        this.book = book;
        this.buyer = buyer;
        this.quantity = quantity;
    }

    // Getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBuyer() {
        return this.buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
