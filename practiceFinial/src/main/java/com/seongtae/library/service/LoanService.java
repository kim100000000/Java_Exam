package com.seongtae.library.service;

import com.seongtae.library.domain.Book;
import com.seongtae.library.domain.Loan;
import com.seongtae.library.repository.BookRepository;
import com.seongtae.library.repository.LoanRepository;

import java.time.LocalDate;

public class LoanService {
    private final BookRepository books;
    private final LoanRepository loans;

    public LoanService(BookRepository books, LoanRepository loans){
        this.books = books; this.loans = loans;
    }

    /** 대출: 재고 1 감소, 대출 레코드 생성 */
    public Loan loan(long userId, long bookId){
        Book b = books.findById(bookId).orElseThrow(()->new IllegalArgumentException("도서 없음: "+bookId));
        if(b.getStock() <= 0) throw new IllegalArgumentException("재고 부족");
        b.setStock(b.getStock()-1);
        books.save(b);

        Loan loan = new Loan(0L, userId, bookId, LocalDate.now(), null);
        return loans.save(loan);
    }

    /** 반납: 재고 1 증가, 대출 레코드에 returnDate 기록 */
    public Loan returnBook(long loanId){
        Loan loan = loans.findById(loanId).orElseThrow(()->new IllegalArgumentException("대출 기록 없음: "+loanId));
        if(loan.isReturned()) throw new IllegalArgumentException("이미 반납된 대출입니다.");
        loan.setReturnDate(LocalDate.now());
        Loan saved = loans.save(loan);

        books.findById(loan.getBookId()).ifPresent(b->{ b.setStock(b.getStock()+1); books.save(b); });
        return saved;
    }
}
