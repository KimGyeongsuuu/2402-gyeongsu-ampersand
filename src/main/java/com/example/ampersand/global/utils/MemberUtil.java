package com.example.ampersand.global.utils;

import com.example.ampersand.domain.auth.exception.MemberNotFoundException;
import com.example.ampersand.domain.member.entity.Member;
import com.example.ampersand.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemberUtil {

    private final MemberRepository memberRepository;

    public Member currentMember(){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 회원입니다."));
    }
}