package com.example.ampersand.domain.product.service;

import com.example.ampersand.domain.product.presentation.dto.request.RegisterProductRequest;

public interface RegisterProductService {
    void execute(RegisterProductRequest registerProductRequest);
}
