package com.programming3final.bookstore.entity;

// import java.math.BigDecimal;

public class CartInfoDTO {

    private int cartId;
    private String bookTitle;
    private String bookAuthor;
    private String bookImage;
    private int bookPrice;
    private int bookQuantity;
    private String buyerUsername;

    public CartInfoDTO() {
    }

    public CartInfoDTO(int cartId, String bookTitle, String bookAuthor, String bookImage, int bookPrice,
            int bookQuantity, String buyerUsername) {
        this.cartId = cartId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.buyerUsername = buyerUsername;
    }

    public CartInfoDTO(String bookTitle, String bookAuthor, String bookImage, int bookPrice,
            int bookQuantity, String buyerUsername) {

        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookImage = bookImage;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.buyerUsername = buyerUsername;
    }

    // Getters and setters

    public int getCartId() {
        return this.cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return this.bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookImage() {
        return this.bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public int getBookPrice() {
        return this.bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookQuantity() {
        return this.bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBuyerUsername() {
        return this.buyerUsername;
    }

    public void setBuyerUsername(String buyerUsername) {
        this.buyerUsername = buyerUsername;
    }

}
