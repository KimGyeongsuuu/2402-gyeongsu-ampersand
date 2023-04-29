package com.example.ampersand.global.exception.handler;

import com.example.ampersand.domain.auth.exception.DuplicateIdException;
import com.example.ampersand.domain.auth.exception.MemberNotFoundException;
import com.example.ampersand.domain.auth.exception.MisMatchPasswordException;
import com.example.ampersand.global.exception.ErrorMessage;
import com.example.ampersand.global.security.exception.TokenExpirationException;
import com.example.ampersand.global.security.exception.TokenNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<ErrorMessage> handleDuplicateIdException(HttpServletRequest request, DuplicateIdException exception) {
        printError(request, exception, exception.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenExpirationException.class)
    public ResponseEntity<ErrorMessage> handleTokenExpirationException(HttpServletRequest request, TokenExpirationException exception) {
        printError(request, exception, exception.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<ErrorMessage> handleTokenNotValidException(HttpServletRequest request, TokenExpirationException exception) {
        printError(request, exception, exception.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleMemberNotFoundException(HttpServletRequest request, MemberNotFoundException exception) {
        printError(request, exception, exception.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MisMatchPasswordException.class)
    public ResponseEntity<ErrorMessage> handleMisMatchPasswordException(HttpServletRequest request, MisMatchPasswordException exception) {
        printError(request, exception, exception.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    private void printError(HttpServletRequest request, RuntimeException ex, String message){
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }
}
