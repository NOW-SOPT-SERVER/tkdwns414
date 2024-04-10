package org.example.classes;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public String createAccount(String password) {
        Account newAccount = new BankAccount(password);
        accounts.put(newAccount.createAccount(password), newAccount);
        return newAccount.createAccount(password);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

