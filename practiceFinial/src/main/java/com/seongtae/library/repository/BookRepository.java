package com.seongtae.library.repository;

import com.seongtae.library.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    boolean deleteById(long id);
    Optional<Book> findById(long id);
    Optional<Book> findByIsbn(String isbn);
    List<Book> findAll();
    List<Book> findByTitleContains(String keyword);
    long nextId();
}
