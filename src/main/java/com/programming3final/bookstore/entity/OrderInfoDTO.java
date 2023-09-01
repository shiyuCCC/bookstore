package com.programming3final.bookstore.entity;

public class OrderInfoDTO {

    private String bookAuthor;
    private String bookTitle;
    private int bookQuantity;
    private int bookPrice;
    private String imageUrl;
    private int total;
    private int GST;
    private int QST;
    private int shipping;


    // Constructors


    public OrderInfoDTO() {
    }

    public OrderInfoDTO(String bookAuthor, String bookTitle, int bookQuantity, int bookPrice, String imageUrl, int total, int GST, int QST, int shipping) {
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookQuantity = bookQuantity;
        this.bookPrice = bookPrice;
        this.imageUrl = imageUrl;
        this.total = total;
        this.GST = GST;
        this.QST = QST;
        this.shipping = shipping;
    }


    //Getters and setters

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getGST() {
        return GST;
    }

    public void setGST(int GST) {
        this.GST = GST;
    }

    public int getQST() {
        return QST;
    }

    public void setQST(int QST) {
        this.QST = QST;
    }

    public int getShipping() {
        return shipping;
    }

    public void setShipping(int shipping) {
        this.shipping = shipping;
    }
}
