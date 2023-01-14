package com.example.service;

import com.example.entity.Account;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface AccountService {
    @Bean
    //save
    Account saveAccount(Account account);
    //read all
    List<Account>fetchAccountList();
    //read by id
    Account fettchAccountById(int id);

    boolean evalAccount(int account);
    boolean evalAmount(double amount);
}
