package com.example.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Getter
public class SameSourceTargetAccException extends RuntimeException{
   private String message="same source and traget account";

}
