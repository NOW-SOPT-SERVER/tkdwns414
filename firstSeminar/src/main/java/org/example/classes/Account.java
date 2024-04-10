package org.example.classes;

public interface Account {
    String createAccount(String password);
    int getBalance();
    void deposit(int amount);
    boolean transfer(Account toAccount, String password, int amount);
}

