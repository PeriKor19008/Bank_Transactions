package com.example.service;

import com.example.dto.TransactionDto;
import com.example.exception.InsufficientAmountException;
import com.example.exception.SameSourceTargetAccException;
import com.example.utils.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTransactionServiceImplTest {

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
        assertThrows(InsufficientAmountException.class,
                ()->{
                    service.evalTransaction(transaction);
                });
    }
}

