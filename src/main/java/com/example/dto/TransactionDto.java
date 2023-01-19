package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
public class TransactionDto {
    @NotNull
    private int sourceAccount;
    @NotNull
    private int targetAccount;
    @NotNull
    private double amount;
    private enum currency {
        EURO,
        US_DOLAR,
        GB_POUND
    }
    public double getAmountByDollar(){
        // place holder
        // it should return amount converted in dolars
        return amount;
    }


}