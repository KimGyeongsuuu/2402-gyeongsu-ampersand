package com.example.ampersand.domain.auth.service.impl;

import com.example.ampersand.domain.auth.entity.RefreshToken;
import com.example.ampersand.domain.auth.exception.MemberNotFoundException;
import com.example.ampersand.domain.auth.exception.MisMatchPasswordException;
import com.example.ampersand.domain.auth.presentation.dto.request.SignInRequest;
import com.example.ampersand.domain.auth.presentation.dto.response.TokenResponse;
import com.example.ampersand.domain.auth.repository.RefreshTokenRepository;
import com.example.ampersand.domain.auth.service.SignInService;
import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.member.repository.MemberRepository;
import com.example.ampersand.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public TokenResponse execute(SignInRequest signInRequest) {

        Member member = memberRepository.findById(signInRequest.getId())
                .orElseThrow(()->new MemberNotFoundException("존재하지 않는 멤버입니다"));

        if (!passwordEncoder.matches(signInRequest.getPassword(), member.getPassword())){
            throw new MisMatchPasswordException("비밀번호가 일치하지 않습니다.");
        }

        String accessToken = tokenProvider.generatedAccessToken(signInRequest.getId());
        String refreshToken = tokenProvider.generatedRefreshToken(signInRequest.getId());
        RefreshToken entityRedis = new RefreshToken(signInRequest.getId(), refreshToken,tokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());

        refreshTokenRepository.save(entityRedis);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(tokenProvider.getExpiredAtToken())
                .build();
    }
}
