package com.example.ampersand.domain.member.service.impl;

import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.member.presentation.dto.response.GetMemberResponse;
import com.example.ampersand.domain.member.service.GetRegisterProductService;
import com.example.ampersand.domain.product.entity.Product;
import com.example.ampersand.domain.product.presentation.dto.response.GetProductResponse;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.global.utils.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GetRegisterProductServiceImpl implements GetRegisterProductService {

    private final ProductRepository productRepository;
    private final MemberUtil memberUtil;

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<GetProductResponse> execute() {
        Member member = memberUtil.currentMember();
        List<Product> products = productRepository.findByMember(member);
        return products.stream()
                .map(product -> GetProductResponse.builder()
                        .productId(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());

    }
}