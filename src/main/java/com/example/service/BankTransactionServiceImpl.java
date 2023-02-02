package com.example.service;

import com.example.dto.TransactionDto;
import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.exception.IncorectAccountIdException;
import com.example.exception.InsufficientAmountException;
import com.example.exception.SameSourceTargetAccException;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public TransactionDto getTransaction(TransactionDto transaction) {
        System.out.println(transaction);
        return transaction;
    }
    @Override
    @Transactional
    public int evalTransaction(TransactionDto transaction) {
        int sourceId=transaction.getSourceAccount();
        int targetId=transaction.getTargetAccount();
        if(sourceId==targetId)
            throw new SameSourceTargetAccException();


        //eval accounts
        Optional<Account> source = accountRepository.findById(sourceId);
        Optional<Account> target = accountRepository.findById(targetId);

        if (source.isEmpty())
            throw new IncorectAccountIdException();
        else if (target.isEmpty())
            throw new IncorectAccountIdException();

        Account sourceAccount=source.get();
        Account targetAccount=target.get();



        if (sourceAccount.getBalance()< transaction.getAmount()){
            throw new InsufficientAmountException();
        }
        else {
            //make transaction
            /*transactionRepository.insertWithQuery(transaction.getSourceAccount(),
                    transaction.getTargetAccount(),
                    transaction.getAmount(),
                    transaction.getCurrencyName());
            return makeTransaction(transaction);*/
            sourceAccount.setBalance(sourceAccount.getBalance()-transaction.getAmount());
            targetAccount.setBalance(targetAccount.getBalance()+transaction.getAmount());
            accountRepository.save(sourceAccount);
            accountRepository.save(targetAccount);
            Transaction transact=new Transaction(sourceId,targetId,transaction.getAmount(),transaction.getCurrency());
            transactionRepository.save(transact);
            return 0;
        }
    }





    @Override
    public int makeTransaction(TransactionDto transactionDto) {
        //to avoid race conditions the  transaction should happen
        //at the database. We should just post the transaction
        //and let the account changes due to the transaction
        //happen from a trigger on insert at the transaction table

        System.out.println("make transaction");
        return 0;
    }
}
