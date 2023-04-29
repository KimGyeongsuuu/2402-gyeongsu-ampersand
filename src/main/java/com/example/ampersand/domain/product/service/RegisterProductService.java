package com.example.ampersand.domain.product.service;

import com.example.ampersand.domain.product.presentation.dto.request.RegisterRequest;

public interface RegisterProductService {
    void execute(RegisterRequest registerRequest);
}
