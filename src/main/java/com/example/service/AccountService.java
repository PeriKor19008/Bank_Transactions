package com.example.service;

import com.example.entity.Account;
import java.util.List;

public interface AccountService {
    //save
    Account saveAccount(Account account);
    //read all
    List<Account>fetchAccountList();
    //read by id
    Account fettchAccountById(int id);
}
