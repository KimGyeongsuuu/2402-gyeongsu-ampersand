package com.example.ampersand.domain.product.service.impl;

import com.example.ampersand.domain.member.presentation.dto.response.GetMemberResponse;
import com.example.ampersand.domain.product.entity.Product;
import com.example.ampersand.domain.product.presentation.dto.response.GetProductResponse;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.domain.product.service.GetProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GetProductServiceImpl implements GetProductService {

    private final ProductRepository productRepository;

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<GetProductResponse> execute() {

        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> GetProductResponse.builder()
                        .productId(product.getId())
                        .name(product.getName())
                        .content(product.getContent())
                        .price(product.getPrice())
                        .member(GetMemberResponse.convertToMember(product.getMember()))
                        .build())
                .collect(Collectors.toList());

    }
}
