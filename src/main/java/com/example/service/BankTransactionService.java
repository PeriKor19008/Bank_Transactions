package com.example.service;

import com.example.dto.TransactionDto;

public interface BankTransactionService {
    public TransactionDto getTransaction(TransactionDto transaction);
    public int evalTransaction(TransactionDto transaction);
    public int makeTransaction(TransactionDto transactionDto);
    public boolean evalAccount(int accId);
    public boolean evalAmount(double amount);
}
