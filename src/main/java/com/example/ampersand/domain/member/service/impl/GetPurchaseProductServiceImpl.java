package com.example.ampersand.domain.member.service.impl;

import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.member.service.GetPurchaseProductService;
import com.example.ampersand.domain.product.presentation.dto.response.GetProductResponse;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.domain.product.service.GetProductService;
import com.example.ampersand.domain.purchase.entity.Purchase;
import com.example.ampersand.domain.purchase.repository.PurchaseRepository;
import com.example.ampersand.global.utils.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GetPurchaseProductServiceImpl implements GetPurchaseProductService {

    private final PurchaseRepository purchaseRepository;
    private final MemberUtil memberUtil;

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    @Override
    public List<GetProductResponse> execute() {

        Member member = memberUtil.currentMember();
        List<Purchase> purchases = purchaseRepository.findByMember(member);
        return purchases.stream()
                .map(purchase -> GetProductResponse.builder()
                        .productId(purchase.getProduct().getId())
                        .name(purchase.getProduct().getName())
                        .price(purchase.getProduct().getPrice())
                        .build())
                .collect(Collectors.toList());

    }
}
