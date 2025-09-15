package com.seongtae.level02.normal.book.model.dto;

public class BookDTO {

    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    public BookDTO(){}

    public BookDTO(String t, String pb, String a) {
        this.title = t;
        this.publisher = pb;
        this.author = a;
    }
    public BookDTO(String t, String pb, String a, int pr, double di) {
        this.title = t;
        this.publisher = pb;
        this.author = a;
        this.price = pr;
        this.discountRate = di;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void printInformation() {
        System.out.println(this.title+", " + this.publisher+", " + this.author +", "+ this.price + ", " + this.discountRate);

    }
}
