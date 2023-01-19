package com.example.service;

import com.example.dto.TransactionDto;
import com.example.entity.Account;
import com.example.exception.IncorectAccountIdException;
import com.example.exception.InsufficientAmountException;
import com.example.exception.SameSourceTargetAccException;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public TransactionDto getTransaction(TransactionDto transaction) {
        System.out.println(transaction);
        return transaction;
    }
    @Override
    public int evalTransaction(TransactionDto transaction) {
        int sourceId=transaction.getSourceAccount();
        int targetId=transaction.getTargetAccount();
        if(sourceId==targetId)
            throw new SameSourceTargetAccException("same source and target account");
        List<Account> accounts = evalAccount(sourceId,targetId);
        if (accounts.get(0).getBalance()< transaction.getAmount()){
            throw new InsufficientAmountException("Insufficient balance");
        }
        else {
            return makeTransaction(transaction);
        }
    }


    @Override
    public List<Account> evalAccount(int sourceId, int targetId){
        Optional<Account> source = accountRepository.findById(sourceId);
        Optional<Account> target = accountRepository.findById(targetId);
        if (source.isEmpty())
            throw new IncorectAccountIdException("Source");
        else if (target.isEmpty())
            throw new IncorectAccountIdException("Target");
        List<Account> accounts = new ArrayList<>();
        accounts.add(source.get());
        accounts.add(target.get());
        return accounts;

    }


    @Override
    public int makeTransaction(TransactionDto transactionDto) {
        //to avoid race conditions the  transaction should happen
        //at the database. We should just post the transaction
        //and let the account changes due to the transaction
        //happen from a trigger on insert at the transaction table
        return 0;
    }
}
