package com.example.controller;

import com.example.dto.TransactionDto;
import com.example.service.BankTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BankTransactionsController {





    private final BankTransactionServiceImpl bankTransactionService;



    @Autowired
    public BankTransactionsController(BankTransactionServiceImpl bankTransactionService){
        this.bankTransactionService = bankTransactionService;
    }
    @PostMapping(value = "/transaction")
    public void transaction(@RequestBody TransactionDto transaction){
        bankTransactionService.getTransaction(transaction);
    }



}
