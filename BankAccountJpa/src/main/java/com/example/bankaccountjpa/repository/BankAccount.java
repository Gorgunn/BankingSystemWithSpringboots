package com.example.bankaccountjpa.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BankAccount {

    @Id
    private String accountnumber;
    private String name;
    private String branch;
    private double amount;
}
