package com.example.ampersand.domain.product.exception;


import com.example.ampersand.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicateNameException extends RuntimeException{

    private final ErrorCode errorCode;

    public DuplicateNameException(String message){
        super(message);
        this.errorCode = ErrorCode.DUPLICATE_NAME;
    }
}
