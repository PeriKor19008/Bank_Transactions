package com.example.entity;
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
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    @NotNull
    private int sourceAccount;
    @NotNull
    private int targetAccount;
    @NotNull
    private double amount;
    private enum currency {
        EURO,
        US_DOLAR,
        GB_POUND
    }

    @OneToMany (mappedBy = "transaction")
    private List<Account> accountList;
}



