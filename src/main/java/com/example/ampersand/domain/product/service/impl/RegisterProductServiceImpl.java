package com.example.ampersand.domain.product.service.impl;


import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.product.entity.Product;
import com.example.ampersand.domain.product.presentation.dto.request.RegisterRequest;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.domain.product.service.RegisterProductService;
import com.example.ampersand.global.utils.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterProductServiceImpl implements RegisterProductService {

    private final ProductRepository productRepository;
    private final MemberUtil memberUtil;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void execute(RegisterRequest registerRequest) {

        Member member = memberUtil.currentMember();

        Product product = Product.builder()
                .name(registerRequest.getName())
                .content(registerRequest.getContent())
                .price(registerRequest.getPrice())
                .member(member)
                .build();

        productRepository.save(product);
    }
}
