package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


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
    @NotNull
    private int id;

    private double balance;
    private enum currency{
        EURO,
        US_DOLAR,
        GB_POUND
    };
    @NotNull
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "id")
    private Transaction transaction;
}
