package com.example.ampersand.domain.auth.exception;

import com.example.ampersand.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicateIdException extends RuntimeException{

    private final ErrorCode errorCode;

    public DuplicateIdException(String message) {
        super(message);
        this.errorCode = ErrorCode.DUPLICATE_ID_EXCEPTION;
    }
}
