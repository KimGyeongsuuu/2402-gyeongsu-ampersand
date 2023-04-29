package com.example.ampersand.domain.member.repository;

import com.example.ampersand.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findById(String id);
    boolean existsById(String id);
}
