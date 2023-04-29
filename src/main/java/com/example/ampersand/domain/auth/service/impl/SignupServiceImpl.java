package com.example.ampersand.domain.auth.service.impl;


import com.example.ampersand.domain.auth.exception.DuplicateIdException;
import com.example.ampersand.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.ampersand.domain.auth.service.SignUpService;
import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void execute(SignUpRequest signUpRequest) {

        if (memberRepository.existsById(signUpRequest.getId())) {
            throw new DuplicateIdException("이미 존재하는 id 입니다.");
        }

        Member member = Member.builder()
                .id(signUpRequest.getId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();

        memberRepository.save(member);

    }

}
