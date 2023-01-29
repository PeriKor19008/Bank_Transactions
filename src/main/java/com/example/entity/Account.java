package com.example.entity;
import com.example.utils.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;




// Annotations

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private int id;

    @Column(nullable = false, name = "balance")
    private double balance;

    @Column(nullable = false, name="currency")
    private Currency currency;

    @Column(nullable = false, name="createdat")
    private String createdAt;


}
