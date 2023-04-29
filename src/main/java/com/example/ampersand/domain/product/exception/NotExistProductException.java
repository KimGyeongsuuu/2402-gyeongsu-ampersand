package com.example.ampersand.domain.product.exception;


import com.example.ampersand.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NotExistProductException extends RuntimeException{

    private final ErrorCode errorCode;

    public NotExistProductException(String message){
        super(message);
        this.errorCode = ErrorCode.NOT_EXIST_PRODUCT;
    }
}
