package com.seongtae.library.service;

import com.seongtae.library.domain.Book;
import com.seongtae.library.repository.BookRepository;

import java.util.List;

public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    /** 도서 등록 */
    public Book register(String title, String author, String isbn, int stock) {
        validateCreate(title, author, isbn, stock);
        repo.findByIsbn(isbn).ifPresent(b -> {
            throw new IllegalArgumentException("이미 존재하는 ISBN 입니다: " + isbn);
        });
        return repo.save(new Book(0L, title, author, isbn, stock));
    }

    /** 도서 전체 조회 */
    public List<Book> list() {
        return repo.findAll();
    }

    /** 제목 검색 */
    public List<Book> searchByTitle(String keyword) {
        if (keyword == null || keyword.isBlank()) return List.of();
        return repo.findByTitleContains(keyword);
    }

    /** 도서 수정 */
    public Book update(long id, String title, String author, String isbnMustSame, int stock) {
        Book existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 도서: id=" + id));

        // ISBN은 수정 불가
        if (!existing.getIsbn().equalsIgnoreCase(isbnMustSame)) {
            throw new IllegalArgumentException("ISBN은 수정할 수 없습니다. 기존=" +
                    existing.getIsbn() + ", 입력=" + isbnMustSame);
        }

        if (title == null || title.isBlank()) throw new IllegalArgumentException("제목은 필수입니다.");
        if (author == null || author.isBlank()) throw new IllegalArgumentException("저자는 필수입니다.");
        if (stock < 0) throw new IllegalArgumentException("재고는 음수가 될 수 없습니다.");

        existing.setTitle(title);
        existing.setAuthor(author);
        existing.setStock(stock);
        return repo.save(existing);
    }

    /** 도서 삭제 */
    public boolean remove(long id) {
        return repo.deleteById(id);
    }

    /** 등록 검증 */
    private void validateCreate(String title, String author, String isbn, int stock) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("제목은 필수입니다.");
        if (author == null || author.isBlank())
            throw new IllegalArgumentException("저자는 필수입니다.");
        if (isbn == null || isbn.isBlank())
            throw new IllegalArgumentException("ISBN은 필수입니다.");
        if (stock < 0)
            throw new IllegalArgumentException("재고는 음수가 될 수 없습니다.");
    }
}
