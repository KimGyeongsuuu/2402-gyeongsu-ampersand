package com.example.ampersand.domain.auth.service;

import com.example.ampersand.domain.auth.presentation.dto.request.SignUpRequest;

public interface SignUpService {
    void execute(SignUpRequest signUpRequest);
}
