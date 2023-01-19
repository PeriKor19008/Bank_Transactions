package com.example.entity;
import com.example.utils.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id",nullable = false)
    private int id;
    @Column(nullable = false, name = "sourceAccount")
    private int sourceAccount;

    @Column(nullable = false, name = "targetAccount")
    private int targetAccount;

    @Column(nullable = false, name = "amount")
    private double amount;

    @Column(nullable = false, name="currency")
    private Currency currency;

}



