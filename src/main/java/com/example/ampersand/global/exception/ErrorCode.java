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
    DUPLICATE_ID_EXCEPTION("이미 존재하는 id 입니다.",400),
    MEMBER_NOT_FOUND("존재하지 않는 회원입니다.",404),
    MISMATCH_PASSWORD("비밀번호가 일치하지 않습니다.",400),

    // PRODUCT
    NOT_EXIST_PRODUCT("존재하지 않은 상품입니다.",404),

    // MEMBER
    NOT_VERIFY_MEMBER("인증되지 않은 회원임니다",401);

    private final String message;

    private final int status;

}
