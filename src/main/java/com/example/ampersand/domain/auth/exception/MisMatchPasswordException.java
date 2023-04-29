package com.example.ampersand.domain.auth.exception;


import com.example.ampersand.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MisMatchPasswordException extends RuntimeException{

    private final ErrorCode errorCode;

    public MisMatchPasswordException(String message){
        super(message);
        this.errorCode = ErrorCode.MISMATCH_PASSWORD;
    }
}
