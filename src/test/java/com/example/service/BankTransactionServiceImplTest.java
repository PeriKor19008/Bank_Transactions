package com.example.service;

import com.example.dto.TransactionDto;
import com.example.entity.Account;
import com.example.exception.InsufficientAmountException;
import com.example.exception.SameSourceTargetAccException;
import com.example.repository.AccountRepository;
import com.example.utils.Currency;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BankTransactionServiceImplTest {

    @Autowired
    AccountRepository accountRepository;
    @Test
    void evalTransactionSameAcc() {
        BankTransactionServiceImpl service = new BankTransactionServiceImpl();
        TransactionDto transaction = new TransactionDto(3,3,2.5,Currency.EURO);
        assertThrows(SameSourceTargetAccException.class,
                ()->{
            service.evalTransaction(transaction);
                });
    }

    @Test
    void evalTransactionInsufficientAm() {
        BankTransactionServiceImpl service = new BankTransactionServiceImpl();
        TransactionDto transaction = new TransactionDto(3,4,3.5,Currency.EURO);
        Account soure= new Account(3,1,Currency.EURO,"20/01/2019");
        Account target= new Account(4,1,Currency.EURO,"20/01/2019");


        Mockito.when(accountRepository.findById(3)).thenReturn(Optional.of(soure));
        Mockito.when(accountRepository.findById(4)).thenReturn(Optional.of(target));
        assertThrows(InsufficientAmountException.class,
                ()->{
                    service.evalTransaction(transaction);
                });
    }
}

