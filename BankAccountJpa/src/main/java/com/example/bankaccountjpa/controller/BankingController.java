package com.example.bankaccountjpa.controller;

import com.example.bankaccountjpa.repository.BankAccount;
import com.example.bankaccountjpa.repository.BankingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller

public class BankingController {
    @Autowired
    private BankingInterface banking;

    @RequestMapping(value = "/accounting/createAccount", method = RequestMethod.POST)
    public @ResponseBody boolean addAccount(@RequestBody BankAccount acc) {
        banking.save(acc);
        return true;
    }

    @RequestMapping(value = "/accounting/searchAccount", method = RequestMethod.GET)
    public @ResponseBody BankAccount getAccountByNumber(@RequestParam("accountNumber") String accountNumber) {
        return banking.findByAccountnumber(accountNumber);
    }

    @RequestMapping(value = "/accounting/listAllAccount", method = RequestMethod.GET)
    public @ResponseBody Collection<BankAccount> getAllAccounts() {
        return banking.findAll();
    }

    @RequestMapping(value = "/accounting/updateAccount", method = RequestMethod.POST)
    public @ResponseBody boolean updateAccount(@RequestParam("accountnumber")String accountnumber, @RequestParam("newamount")Double newamount) {
        BankAccount tempaccount = banking.findByAccountnumber(accountnumber);
        tempaccount.setAmount(newamount);
        banking.save(tempaccount);
        return true;

    }

    @RequestMapping(value = "/accounting/transfer", method = RequestMethod.POST)
    public @ResponseBody boolean transfer(@RequestParam("senderAccNumber") String senderAccNumber, @RequestParam("receiverAccNumber") String receiverAccNumber, @RequestParam("amount") double amount) {
        BankAccount sender = banking.findByAccountnumber(senderAccNumber);
        BankAccount receiver= banking.findByAccountnumber(receiverAccNumber);
        if (sender.getAmount() < amount) {
            return false;
        }
        sender.setAmount(sender.getAmount() - amount);
        receiver.setAmount(receiver.getAmount() + amount);
        banking.save(receiver);
        banking.save(receiver);
        return true;
    }

    @RequestMapping(value = "/accounting/deleteAccount", method = RequestMethod.POST)
    public @ResponseBody boolean deleteAccount(@RequestParam("accountnumber")String accountnumber) {
        BankAccount acc = banking.findByAccountnumber(accountnumber);
        banking.delete(acc);
        return true;
    }

}
