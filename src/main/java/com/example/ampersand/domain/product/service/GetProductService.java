package com.example.ampersand.domain.product.service;

import com.example.ampersand.domain.product.presentation.dto.response.GetProductResponse;

import java.util.List;

public interface GetProductService {
    List<GetProductResponse> execute();
}
