package com.example.ampersand.domain.purchase.service.impl;

import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.purchase.entity.Purchase;
import com.example.ampersand.domain.purchase.repository.PurchaseRepository;
import com.example.ampersand.domain.purchase.service.PurchaseProductService;
import com.example.ampersand.domain.product.entity.Product;
import com.example.ampersand.domain.product.exception.NotExistProductException;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.global.utils.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseProductServiceImpl implements PurchaseProductService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final MemberUtil memberUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void execute(Long productId) {
        Member member = memberUtil.currentMember();
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new NotExistProductException("존재하지 않은 상품입니다."));
        Purchase purchase= Purchase.builder()
                .product(product)
                .member(member)
                .build();

        purchaseRepository.save(purchase);

    }
}
