package com.seongtae.library.repository;

import com.seongtae.library.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(long id);
    List<Member> findAll();
    boolean deleteById(long id);
    long nextId();
}
