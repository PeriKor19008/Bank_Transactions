package com.example.repository;

import com.example.dto.TransactionDto;
import com.example.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Integer> {


    @Modifying
    @Query (value =
            "insert INTO person (sourceAccountId, targetAccountId, amount,currency) values (:sourceAccountId, :targetAccountId, :amount,:currency)",
            nativeQuery = true)
    public void insertWithQuery(@Param("sourceAccountId") int sourceAccountId,
                                @Param("targetAccountId") int targetAccountId,
                                @Param("amount") double amount,
                                @Param("currency") String currency);
   /* @Param("id")*/




}

