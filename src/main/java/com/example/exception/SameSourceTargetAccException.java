package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SameSourceTargetAccException extends RuntimeException{
   private String message;
}
