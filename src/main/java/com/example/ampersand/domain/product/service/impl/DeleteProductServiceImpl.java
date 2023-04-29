package com.example.ampersand.domain.product.service.impl;

import com.example.ampersand.domain.member.exception.NotVerifyMember;
import com.example.ampersand.domain.product.entity.Product;
import com.example.ampersand.domain.product.exception.NotExistProductException;
import com.example.ampersand.domain.product.repository.ProductRepository;
import com.example.ampersand.domain.product.service.DeleteProductService;
import com.example.ampersand.global.utils.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DeleteProductServiceImpl implements DeleteProductService {

    private final ProductRepository productRepository;
    private final MemberUtil memberUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void execute(Long id) {
        Product product = productRepository.findById(id)
                        .orElseThrow(()->new NotExistProductException("존재하지 않은 상품입니다."));
        verifyPostWriter(product);
        productRepository.deleteById(id);
    }

    private void verifyPostWriter(Product product) {
        if (!memberUtil.currentMember().equals(product.getMember())) {
            throw new NotVerifyMember("검증되지 않은 회원입니다.");
        }
    }
}
