package com.seongtae.library.domain;

import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private String author;
    private String isbn;
    private int stock;

    public Book(long id, String title, String author, String isbn, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.stock = stock;
    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    @Override public boolean equals(Object o){ return o instanceof Book b && b.id==id; }
    @Override public int hashCode(){ return Objects.hash(id); }
    @Override public String toString(){ return "Book{id=%d, title='%s', author='%s', isbn='%s', stock=%d}"
            .formatted(id, title, author, isbn, stock); }
}
