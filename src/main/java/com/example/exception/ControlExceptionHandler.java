package com.example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControlExceptionHandler
    extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IncorectAccountIdException.class,InsufficientAmountException.class, SameSourceTargetAccException.class})
    public ResponseEntity<Object>
    incorectAccountIdException(IncorectAccountIdException ex, WebRequest request) {
        String bodyOfResponse = "Transaction unsuccessful";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>
    unexpectedException(IncorectAccountIdException ex, WebRequest request) {
        String bodyOfResponse = "An exception was thrown";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
