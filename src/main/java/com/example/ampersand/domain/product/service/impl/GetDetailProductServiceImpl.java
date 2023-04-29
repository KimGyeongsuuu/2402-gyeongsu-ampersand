package com.example.ampersand.domain.product.service.impl;


import com.example.ampersand.domain.member.presentation.dto.response.GetMemberResponse;
import com.example.ampersand.domain.product.entity.Product;
import com.example.ampersand.domain.product.exception.NotExistProductException;
import com.example.ampersand.domain.product.presentation.dto.response.GetDetailProductResponse;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.domain.product.service.GetDetailProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class GetDetailProductServiceImpl implements GetDetailProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public GetDetailProductResponse execute(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(()->new NotExistProductException("존재하지 않은 상품입니다."));
        return GetDetailProductResponse.builder()
                .productId(product.getId())
                .name(product.getName())
                .content(product.getContent())
                .price(product.getPrice())
                .member(GetMemberResponse.convertToMember(product.getMember()))
                .build();

    }

}
