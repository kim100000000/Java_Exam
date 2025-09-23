package com.seongtae.library.domain;

import java.time.LocalDate;

public class Loan {
    private long id;
    private long userId;
    private long bookId;
    private LocalDate loanDate;
    private LocalDate returnDate; // null이면 미반납

    public Loan(long id, long userId, long bookId, LocalDate loanDate, LocalDate returnDate) {
        this.id = id; this.userId = userId; this.bookId = bookId;
        this.loanDate = loanDate; this.returnDate = returnDate;
    }

    public long getId(){ return id; }
    public void setId(long id){ this.id = id; }
    public long getUserId(){ return userId; }
    public long getBookId(){ return bookId; }
    public LocalDate getLoanDate(){ return loanDate; }
    public LocalDate getReturnDate(){ return returnDate; }
    public void setReturnDate(LocalDate d){ this.returnDate = d; }

    public boolean isReturned(){ return returnDate != null; }

    @Override public String toString(){
        return "Loan{id=%d, userId=%d, bookId=%d, loan=%s, return=%s}"
                .formatted(id, userId, bookId, loanDate, returnDate);
    }
}
