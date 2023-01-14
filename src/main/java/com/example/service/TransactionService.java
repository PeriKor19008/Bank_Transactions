package com.example.service;

import com.example.entity.Transaction;
import com.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    private AccountService accountService;

    public Transaction getTransaction(Transaction transaction){

        System.out.println(transaction);
        evalTransaction(transaction);
        return transaction;
    }

    public int evalTransaction(Transaction transaction){


        if(!accountService.evalAccount(transaction.getSourceAccount())){
            System.out.println("1");
            return -1;
        }


        else if ((!accountService.evalAccount(transaction.getTargetAccount())))
            return -2;
        else if ((!accountService.evalAmount(transaction.getAmount())))
            return  -3;
        else {
            return transactionRepository.makeTransaction(transaction);
        }



    }


}
