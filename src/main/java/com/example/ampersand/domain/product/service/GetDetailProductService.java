package com.example.ampersand.domain.product.service;

import com.example.ampersand.domain.product.presentation.dto.response.GetDetailProductResponse;

public interface GetDetailProductService {
    GetDetailProductResponse execute(Long id);
}
