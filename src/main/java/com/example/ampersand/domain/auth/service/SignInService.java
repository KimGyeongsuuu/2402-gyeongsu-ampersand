package com.example.ampersand.domain.auth.service;

import com.example.ampersand.domain.auth.presentation.dto.request.SignInRequest;
import com.example.ampersand.domain.auth.presentation.dto.response.TokenResponse;

public interface SignInService {
    TokenResponse execute(SignInRequest signInRequest);
}
