package com.example.ampersand.domain.auth.exception;

import com.example.ampersand.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MemberNotFoundException extends RuntimeException{

    private final ErrorCode errorCode;

    public MemberNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.MEMBER_NOT_FOUND;
    }
}
