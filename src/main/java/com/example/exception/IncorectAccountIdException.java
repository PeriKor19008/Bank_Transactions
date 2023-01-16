package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IncorectAccountIdException
    extends RuntimeException{

    private String message;

}
