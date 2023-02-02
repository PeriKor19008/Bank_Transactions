package com.example.entity;
import com.example.utils.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "Transaction")
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

    public Transaction (int sourceAccount,int targetAccount,double amount,Currency currency){
        this.sourceAccount=sourceAccount;
        this.targetAccount=targetAccount;
        this.amount=amount;
        this.currency=currency;
    }

}



