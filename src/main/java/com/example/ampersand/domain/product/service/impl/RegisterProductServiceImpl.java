package com.example.ampersand.domain.product.service.impl;


import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.product.entity.Product;
import com.example.ampersand.domain.product.exception.DuplicateNameException;
import com.example.ampersand.domain.product.presentation.dto.request.RegisterProductRequest;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.domain.product.service.RegisterProductService;
import com.example.ampersand.global.utils.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class RegisterProductServiceImpl implements RegisterProductService {

    private final ProductRepository productRepository;
    private final MemberUtil memberUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void execute(RegisterProductRequest registerProductRequest) {

        Member member = memberUtil.currentMember();

        if (productRepository.existsByName(registerProductRequest.getName())) {
            throw new DuplicateNameException("이미 존재하는 상품명입니다.");
        }

        Product product = Product.builder()
                .name(registerProductRequest.getName())
                .content(registerProductRequest.getContent())
                .price(registerProductRequest.getPrice())
                .member(member)
                .build();

        productRepository.save(product);
    }
}
