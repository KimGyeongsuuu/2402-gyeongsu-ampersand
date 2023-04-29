package com.example.ampersand.domain.auth.service.impl;


import com.example.ampersand.domain.auth.exception.DuplicateIdException;
import com.example.ampersand.domain.auth.presentation.dto.request.SignupRequest;
import com.example.ampersand.domain.auth.service.SignupService;
import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void execute(SignupRequest signupRequest) {

        if (memberRepository.existsById(signupRequest.getId())){
            throw new DuplicateIdException("이미 존재하는 id 입니다.");
        }

        Member member = Member.builder()
                .id(signupRequest.getId())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .build();
        memberRepository.save(member);

    }

}