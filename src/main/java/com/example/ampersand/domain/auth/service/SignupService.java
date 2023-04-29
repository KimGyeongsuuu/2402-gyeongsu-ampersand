package com.example.ampersand.domain.auth.service;

import com.example.ampersand.domain.auth.presentation.dto.request.SignupRequest;

public interface SignupService {
    void execute(SignupRequest signupRequest);
}
