package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl
    implements AccountService{


    @Autowired
    private AccountRepository accountRepository;

    //save

    @Override
    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    //read

    @Override
    public List<Account> fetchAccountList(){
        return (List<Account>)
                accountRepository.findAll();
    }

    @Override
    public Account fettchAccountById(int id) {
        return null;
    }

    @Override
    public boolean evalAccount(int account) {
        System.out.println("perii");
        long ac = account;

        accountRepository.findById(ac);

        return false;
    }

    @Override
    public boolean evalAmount(double amount) {
        return false;
    }
}
