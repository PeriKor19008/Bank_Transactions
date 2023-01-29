package com.example.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter

public class InsufficientAmountException extends RuntimeException{
    private String message="insufficient amount";

}
