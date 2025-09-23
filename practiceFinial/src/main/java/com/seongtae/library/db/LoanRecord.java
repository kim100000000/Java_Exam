package com.seongtae.library.db;

public class LoanRecord {
    public long id;
    public long userId;
    public long bookId;
    public String loanDate;    // ISO yyyy-MM-dd
    public String returnDate;  // 반환 전에는 빈 문자열

    public LoanRecord() {}
    public LoanRecord(long id, long userId, long bookId, String loanDate, String returnDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
}
