package org.example.classes;

import java.util.Random;

public class BankAccount implements Account {
    private String accountNumber;
    private int balance;
    private String password;

    public BankAccount(String password) {
        this.accountNumber = generateAccountNumber();
        this.password = password;
        this.balance = 0;
    }

    @Override
    public String createAccount(String password) {
        return this.accountNumber;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public boolean transfer(Account toAccount, String password, int amount) {
        if (!this.password.equals(password) || this.balance < amount) {
            return false;
        }
        this.balance -= amount;
        toAccount.deposit(amount);
        return true;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        return String.format("%03d-%03d-%03d", random.nextInt(1000), random.nextInt(1000), random.nextInt(1000));
    }
}

