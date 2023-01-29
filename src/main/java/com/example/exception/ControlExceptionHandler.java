package com.example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControlExceptionHandler {

    @ExceptionHandler({IncorectAccountIdException.class,InsufficientAmountException.class, SameSourceTargetAccException.class})
    public ResponseEntity<Object>
    incorectAccountIdException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();

        return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>
    unexpectedException(Exception ex, WebRequest request) {
        String bodyOfResponse = "An exception was thrown";
        return new ResponseEntity<>(bodyOfResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
