package com.seongtae.library.ui;

import com.seongtae.library.domain.Book;
import com.seongtae.library.domain.Member;
import com.seongtae.library.repository.BookRepository;
import com.seongtae.library.repository.LoanRepository;
import com.seongtae.library.repository.MemberRepository;
import com.seongtae.library.service.BookService;
import com.seongtae.library.service.LoanService;
import com.seongtae.library.service.MemberService;
import com.seongtae.library.storage.BookFileStorage;
import com.seongtae.library.storage.LoanFileStorage;
import com.seongtae.library.storage.MemberFileStorage;

import java.util.List;
import java.util.Scanner;

public class Application {
    private final BookService bookSvc;
    private final MemberService memberSvc;
    private final LoanService loanSvc;

    private final Scanner sc = new Scanner(System.in);

    public Application() {
        BookRepository   books   = new BookFileStorage();
        MemberRepository members = new MemberFileStorage();
        LoanRepository   loans   = new LoanFileStorage();

        this.bookSvc   = new BookService(books);
        this.memberSvc = new MemberService(members);
        this.loanSvc   = new LoanService(books, loans);
    }

    public static void main(String[] args) { new Application().run(); }

    public void run() {
        while (true) {
            printMenu();
            String sel = sc.nextLine().trim();
            try {
                switch (sel) {
                    case "1" -> addBook();
                    case "2" -> listBooks();
                    case "3" -> addMember();
                    case "4" -> listMembers();
                    case "5" -> doLoan();      // 원하면 활성화
                    case "6" -> doReturn();    // 원하면 활성화
                    case "0" -> { System.out.println("Bye!"); return; }
                    default -> System.out.println("메뉴를 다시 선택하세요.");
                }
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("\n===== 도서 관리 시스템 =====");
        System.out.println("1. 도서 등록  |  2. 도서 조회");
        System.out.println("3. 회원 등록  |  4. 회원 조회");
        System.out.println("5. 대출       |  6. 반납");
        System.out.print("0. 종료\n선택> ");
    }

    private void addBook() {
        System.out.print("제목: ");   String title = sc.nextLine();
        System.out.print("저자: ");   String author = sc.nextLine();
        System.out.print("ISBN: ");   String isbn = sc.nextLine();
        System.out.print("재고: ");   int stock = Integer.parseInt(sc.nextLine());
        Book created = bookSvc.register(title, author, isbn, stock);
        System.out.println("등록 완료: " + created);
    }
    private void listBooks() {
        List<Book> list = bookSvc.list();
        if (list.isEmpty()) System.out.println("(비어 있음)");
        else list.forEach(System.out::println);
    }

    private void addMember() {
        System.out.print("회원 이름: ");
        Member m = memberSvc.register(sc.nextLine());
        System.out.println("등록 완료: " + m);
    }
    private void listMembers() {
        List<Member> list = memberSvc.list();
        if (list.isEmpty()) System.out.println("(비어 있음)");
        else list.forEach(System.out::println);
    }

    private void doLoan() {
        System.out.print("회원ID: "); long uid = Long.parseLong(sc.nextLine());
        System.out.print("도서ID: "); long bid = Long.parseLong(sc.nextLine());
        System.out.println("대출 완료: " + loanSvc.loan(uid, bid));
    }
    private void doReturn() {
        System.out.print("대출ID: "); long lid = Long.parseLong(sc.nextLine());
        System.out.println("반납 완료: " + loanSvc.returnBook(lid));
    }



}
