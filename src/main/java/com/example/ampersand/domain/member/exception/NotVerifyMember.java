package com.example.ampersand.domain.member.exception;


import com.example.ampersand.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotVerifyMember extends RuntimeException{

    private final ErrorCode errorCode;

    public NotVerifyMember(String message){
        super(message);
        this.errorCode = ErrorCode.NOT_VERIFY_MEMBER;
    }
}
