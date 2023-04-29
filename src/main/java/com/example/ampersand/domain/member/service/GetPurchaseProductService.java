package com.example.ampersand.domain.member.service;

import com.example.ampersand.domain.product.presentation.dto.response.GetProductResponse;

import java.util.List;

public interface GetPurchaseProductService {
    List<GetProductResponse> execute();
}
