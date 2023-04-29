package com.example.ampersand.domain.product.repository;

import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByMember(Member member);
}
