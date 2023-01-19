package com.example.service;

import com.example.dto.TransactionDto;
import com.example.entity.Account;

import java.util.List;

public interface BankTransactionService {
    TransactionDto getTransaction(TransactionDto transaction);
    int evalTransaction(TransactionDto transaction);
    int makeTransaction(TransactionDto transactionDto);
    List<Account> evalAccount(int sourceId,int targetId);

}
