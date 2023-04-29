package com.example.ampersand.global.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // TOKEN
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),

    // AUTH
    DUPLICATE_ID_EXCEPTION("이미 존재하는 id 입니다.",400);

    private final String message;

    private final int status;

}
