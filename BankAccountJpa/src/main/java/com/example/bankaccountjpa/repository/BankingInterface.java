package com.example.bankaccountjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface BankingInterface extends CrudRepository<BankAccount, String> {
    public BankAccount findByAccountnumber(String accountnumber);
    public Collection<BankAccount> findAll();

}
