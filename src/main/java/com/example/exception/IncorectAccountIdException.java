package com.example.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Getter
public class IncorectAccountIdException
    extends RuntimeException {

    private String message="incorect account";

}
