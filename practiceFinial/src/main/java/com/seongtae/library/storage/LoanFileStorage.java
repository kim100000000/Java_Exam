package com.seongtae.library.storage;

import com.seongtae.library.db.LoanRecord;
import com.seongtae.library.domain.Loan;
import com.seongtae.library.repository.LoanRepository;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LoanFileStorage implements LoanRepository {
    private final Map<Long, Loan> store = new LinkedHashMap<>();
    private long seq = 0L;

    private static final Path DATA_DIR  = Paths.get("data");
    private static final Path LOANS_CSV = DATA_DIR.resolve("loans.csv");

    public LoanFileStorage(){ ensure(); load(); }

    @Override public synchronized Loan save(Loan loan){ if(loan.getId()==0) loan.setId(nextId()); store.put(loan.getId(), loan); persist(); return loan; }
    @Override public Optional<Loan> findById(long id){ return Optional.ofNullable(store.get(id)); }
    @Override public List<Loan> findAll(){ return new ArrayList<>(store.values()); }
    @Override public List<Loan> findByUserId(long uid){ return store.values().stream().filter(l->l.getUserId()==uid).collect(Collectors.toList()); }
    @Override public List<Loan> findByBookId(long bid){ return store.values().stream().filter(l->l.getBookId()==bid).collect(Collectors.toList()); }
    @Override public synchronized boolean deleteById(long id){ Loan rm=store.remove(id); persist(); return rm!=null; }
    @Override public synchronized long nextId(){ return ++seq; }

    /* ---------- CSV ---------- */
    private void ensure(){
        try{ if(!Files.exists(DATA_DIR)) Files.createDirectories(DATA_DIR);
            if(!Files.exists(LOANS_CSV)) Files.createFile(LOANS_CSV);
        }catch(Exception e){ throw new IllegalStateException("loans.csv 준비 실패", e);}
    }
    private void load(){
        try{
            if(Files.size(LOANS_CSV)==0) return;
            for(String line: Files.readAllLines(LOANS_CSV, StandardCharsets.UTF_8)){
                if(line.isBlank()) continue;
                String[] a=line.split(",",-1);
                LoanRecord r = new LoanRecord(
                        Long.parseLong(a[0]),
                        Long.parseLong(a[1]),
                        Long.parseLong(a[2]),
                        a[3],
                        a[4]
                );
                Loan loan = new Loan(
                        r.id, r.userId, r.bookId,
                        LocalDate.parse(r.loanDate),
                        r.returnDate.isBlank()? null: LocalDate.parse(r.returnDate)
                );
                store.put(loan.getId(), loan);
                if(loan.getId()>seq) seq=loan.getId();
            }
        }catch(Exception e){ throw new IllegalStateException("loans.csv 로드 실패", e);}
    }
    private void persist(){
        try(BufferedWriter bw=Files.newBufferedWriter(LOANS_CSV, StandardCharsets.UTF_8)){
            for(Loan l: store.values()){
                String ret = (l.getReturnDate()==null? "": l.getReturnDate().toString());
                bw.write("%d,%d,%d,%s,%s".formatted(l.getId(), l.getUserId(), l.getBookId(), l.getLoanDate(), ret));
                bw.newLine();
            }
        }catch(Exception e){ throw new IllegalStateException("loans.csv 저장 실패", e);}
    }
}
