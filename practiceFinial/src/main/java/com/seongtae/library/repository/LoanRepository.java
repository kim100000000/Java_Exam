package com.seongtae.library.repository;

import com.seongtae.library.domain.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(long id);
    List<Loan> findAll();
    List<Loan> findByUserId(long userId);
    List<Loan> findByBookId(long bookId);
    boolean deleteById(long id);
    long nextId();
}
