package com.seongtae.library.service;

import com.seongtae.library.domain.Member;
import com.seongtae.library.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository repo;
    public MemberService(MemberRepository repo){ this.repo = repo; }

    public Member register(String name){
        if(name==null || name.isBlank()) throw new IllegalArgumentException("이름은 필수입니다.");
        return repo.save(new Member(0L, name.trim()));
    }
    public List<Member> list(){ return repo.findAll(); }
}
