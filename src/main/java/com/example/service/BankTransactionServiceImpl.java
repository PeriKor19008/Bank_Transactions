package com.example.service;

import com.example.dto.TransactionDto;
import com.example.exception.IncorectAccountIdException;
import org.springframework.stereotype.Service;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
    @Override
    public TransactionDto getTransaction(TransactionDto transaction) {
        System.out.println(transaction);
        return transaction;
    }
    @Override
    public int evalTransaction(TransactionDto transaction) {
        if (!evalAccount(transaction.getSourceAccount())) {
            throw new IncorectAccountIdException("Source");
        } else if ((!evalAccount(transaction.getTargetAccount())))
            throw new IncorectAccountIdException("Target");
        else if ((!evalAmount(transaction.getAmount())))
            return -3;
        else {
            return makeTransaction(transaction);
        }
    }
    @Override
    public boolean evalAccount(int accId){ return true; }
    @Override
    public boolean evalAmount(double amount){
        return true;
    }

    @Override
    public int makeTransaction(TransactionDto transactionDto){
        return 0;
    }
}
