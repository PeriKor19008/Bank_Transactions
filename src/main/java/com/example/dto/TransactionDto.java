package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class TransactionDto {
    private int sourceAccount;
    private int targetAccount;
    private double amount;
    private enum currency{
        EURO,
        US_DOLAR,
        GB_POUND
    }


}