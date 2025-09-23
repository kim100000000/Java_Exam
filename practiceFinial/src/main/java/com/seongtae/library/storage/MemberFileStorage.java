package com.seongtae.library.storage;

import com.seongtae.library.domain.Member;
import com.seongtae.library.repository.MemberRepository;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class MemberFileStorage implements MemberRepository {
    private final Map<Long, Member> store = new LinkedHashMap<>();
    private long seq = 0L;

    private static final Path DATA_DIR   = Paths.get("data");
    private static final Path MEMBERS_CSV= DATA_DIR.resolve("members.csv");

    public MemberFileStorage(){ ensure(); load(); }

    @Override public synchronized Member save(Member m){ if(m.getId()==0)m.setId(nextId()); store.put(m.getId(), m); persist(); return m; }
    @Override public Optional<Member> findById(long id){ return Optional.ofNullable(store.get(id)); }
    @Override public List<Member> findAll(){ return new ArrayList<>(store.values()); }
    @Override public synchronized boolean deleteById(long id){ Member rm=store.remove(id); persist(); return rm!=null; }
    @Override public synchronized long nextId(){ return ++seq; }

    private void ensure(){
        try{ if(!Files.exists(DATA_DIR)) Files.createDirectories(DATA_DIR);
            if(!Files.exists(MEMBERS_CSV)) Files.createFile(MEMBERS_CSV);
        }catch(Exception e){ throw new IllegalStateException("members.csv 준비 실패", e);}
    }
    private void load(){
        try{
            if(Files.size(MEMBERS_CSV)==0) return;
            for(String line: Files.readAllLines(MEMBERS_CSV, StandardCharsets.UTF_8)){
                if(line.isBlank()) continue;
                String[] a=line.split(",",-1);
                long id=Long.parseLong(a[0]); String name=a[1];
                store.put(id, new Member(id,name));
                if(id>seq) seq=id;
            }
        }catch(Exception e){ throw new IllegalStateException("members.csv 로드 실패", e);}
    }
    private void persist(){
        try(BufferedWriter bw=Files.newBufferedWriter(MEMBERS_CSV, StandardCharsets.UTF_8)){
            for(Member m: store.values()){
                bw.write("%d,%s".formatted(m.getId(), safe(m.getName())));
                bw.newLine();
            }
        }catch(Exception e){ throw new IllegalStateException("members.csv 저장 실패", e);}
    }
    private String safe(String s){ return s==null? "": s.trim(); }
}
