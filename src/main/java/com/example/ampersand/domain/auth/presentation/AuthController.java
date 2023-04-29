package com.example.ampersand.domain.auth.presentation;


import com.example.ampersand.domain.auth.presentation.dto.request.SignInRequest;
import com.example.ampersand.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.ampersand.domain.auth.presentation.dto.response.TokenResponse;
import com.example.ampersand.domain.auth.service.SignInService;
import com.example.ampersand.domain.auth.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignUpService signupService;
    private final SignInService signInService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid SignUpRequest signUpRequest){
        signupService.execute(signUpRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signin(@RequestBody @Valid SignInRequest signInRequest){
        TokenResponse tokenResponse = signInService.execute(signInRequest);
        return ResponseEntity.ok(tokenResponse);
    }

}
