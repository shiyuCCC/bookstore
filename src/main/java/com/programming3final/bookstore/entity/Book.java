package com.programming3final.bookstore.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book {

    public enum Availability {
        available,
        out_of_stock

    }

    // define field

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "isbn")
    private String isbn;

    @NotBlank(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "author")
    private String author;

    @NotBlank(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "availability")
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "book")
    private List<Cart> carts;

    // constructors: 1.default 2. with id 3.without id

    public Book() {
    }

    public Book(int id, String isbn, String title, String author, String category, int quantity,
            Availability availability, String image_url, int price, String description) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.availability = availability;
        this.image_url = image_url;
        this.price = price;
        this.description = description;
    }

    public Book(String isbn, String title, String author, String category, int quantity, Availability availability,
            String image_url, int price, String description) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.availability = availability;
        this.image_url = image_url;
        this.price = price;
        this.description = description;
    }

    // setters and getters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Availability getAvailability() {
        return this.availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Cart> getCarts() {
        return this.carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

}
