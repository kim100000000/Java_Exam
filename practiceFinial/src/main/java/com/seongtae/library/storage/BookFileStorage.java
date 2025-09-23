package com.seongtae.library.storage;

import com.seongtae.library.domain.Book;
import com.seongtae.library.repository.BookRepository;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookFileStorage implements BookRepository {
    private final Map<Long, Book> store = new LinkedHashMap<>();
    private long seq = 0L;

    private static final Path DATA_DIR  = Paths.get("data");
    private static final Path BOOKS_CSV = DATA_DIR.resolve("books.csv");

    public BookFileStorage() { ensure(); load(); }

    @Override public synchronized Book save(Book b){ if(b.getId()==0)b.setId(nextId()); store.put(b.getId(), b); persist(); return b; }
    @Override public synchronized boolean deleteById(long id){ Book rm=store.remove(id); persist(); return rm!=null; }
    @Override public Optional<Book> findById(long id){ return Optional.ofNullable(store.get(id)); }
    @Override public Optional<Book> findByIsbn(String isbn){
        return store.values().stream().filter(x->x.getIsbn().equalsIgnoreCase(isbn)).findFirst();
    }
    @Override public List<Book> findAll(){ return new ArrayList<>(store.values()); }
    @Override public List<Book> findByTitleContains(String k){
        String q = k==null? "": k.toLowerCase();
        return store.values().stream().filter(b->b.getTitle().toLowerCase().contains(q)).collect(Collectors.toList());
    }
    @Override public synchronized long nextId(){ return ++seq; }

    private void ensure(){
        try{ if(!Files.exists(DATA_DIR)) Files.createDirectories(DATA_DIR);
            if(!Files.exists(BOOKS_CSV)) Files.createFile(BOOKS_CSV);
        }catch(Exception e){ throw new IllegalStateException("books.csv 준비 실패", e);}
    }
    private void load(){
        try{
            if(Files.size(BOOKS_CSV)==0) return;
            for(String line: Files.readAllLines(BOOKS_CSV, StandardCharsets.UTF_8)){
                if(line.isBlank()) continue;
                String[] a=line.split(",",-1);
                long id=Long.parseLong(a[0]); String title=a[1]; String author=a[2]; String isbn=a[3]; int stock=Integer.parseInt(a[4]);
                store.put(id, new Book(id,title,author,isbn,stock));
                if(id>seq) seq=id;
            }
        }catch(Exception e){ throw new IllegalStateException("books.csv 로드 실패", e);}
    }
    private void persist(){
        try(BufferedWriter bw=Files.newBufferedWriter(BOOKS_CSV, StandardCharsets.UTF_8)){
            for(Book b: store.values()){
                bw.write("%d,%s,%s,%s,%d".formatted(b.getId(),safe(b.getTitle()),safe(b.getAuthor()),safe(b.getIsbn()),b.getStock()));
                bw.newLine();
            }
        }catch(Exception e){ throw new IllegalStateException("books.csv 저장 실패", e);}
    }
    private String safe(String s){ return s==null? "": s.trim(); }
}
