package com.example.entity;

import javax.validation.constraints.NotNull;

import com.example.utils.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.*;



// Annotations

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private int id;

    @Column(nullable = false, name = "balance")
    private double balance;

    @Column(nullable = false, name="currency")
    private Currency currency;

    @Column(nullable = false, name="createdAt")
    private String createdAt;


}
