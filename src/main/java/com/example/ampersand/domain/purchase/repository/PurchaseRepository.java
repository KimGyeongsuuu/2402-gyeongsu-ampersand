package com.example.ampersand.domain.purchase.repository;

import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.purchase.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    List<Purchase> findByMember(Member member);
}
