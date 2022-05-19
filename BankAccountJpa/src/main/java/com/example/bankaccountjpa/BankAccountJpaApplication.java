package com.example.bankaccountjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class BankAccountJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(BankAccountJpaApplication.class, args);
    }

}
