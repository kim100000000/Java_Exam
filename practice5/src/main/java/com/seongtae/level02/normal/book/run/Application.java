package com.seongtae.level02.normal.book.run;


import com.seongtae.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO b1 = new BookDTO();
        b1.printInformation();
        BookDTO b2 = new BookDTO("자바의 정석", "도우출판", "남궁성");
        b2.printInformation();
        BookDTO b3 = new BookDTO("홍길동전", "활빈당", "허균", 5000000,0.5);
        b3.printInformation();

    }
}
