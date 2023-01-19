package com.example.controller;

import com.example.dto.TransactionDto;
import com.example.service.BankTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class BankTransactionsController {





    private final BankTransactionServiceImpl bankTransactionService;



    @Autowired
    public BankTransactionsController(BankTransactionServiceImpl bankTransactionService) {
        this.bankTransactionService = bankTransactionService;
    }
    @PostMapping(value = "/transaction")
    public void transaction(@Valid @RequestBody TransactionDto transaction) {
        bankTransactionService.getTransaction(transaction);
    }



}
