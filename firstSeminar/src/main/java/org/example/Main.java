package org.example;

import org.example.classes.Account;
import org.example.classes.Bank;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        while (true) {
            int choice = selectMenu();
            switch (choice) {
                case 1 -> { // 계좌 생성 로직
                    String password = getStringInput("비밀번호를 입력하세요: ");
                    System.out.println("생성된 계좌 번호: " + bank.createAccount(password));
                }
                case 2 -> { // 계좌 조회 로직
                    String accountNumber = getStringInput("계좌 번호를 입력하세요: ");
                    Account account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("계좌 잔액: " + account.getBalance());
                    } else {
                        System.out.println("계좌를 찾을 수 없습니다.");
                    }
                }
                case 3 -> { // 입금 로직
                    String accountNumber = getStringInput("계좌 번호를 입력하세요: ");
                    int amount = getIntInput("입금할 금액을 입력하세요: ");
                    Account account = bank.getAccount(accountNumber);
                    if (account != null) {
                        account.deposit(amount);
                    } else {
                        System.out.println("계좌를 찾을 수 없습니다.");
                    }
                }
                case 4 -> { // 이체 로직
                    String fromAccountNumber = getStringInput("출금할 계좌 번호를 입력하세요: ");
                    String toAccountNumber = getStringInput("입금할 계좌 번호를 입력하세요: ");
                    String password = getStringInput("출금할 계좌의 비밀번호를 입력하세요: ");
                    int amount = getIntInput("이체할 금액을 입력하세요: ");

                    Account fromAccount = bank.getAccount(fromAccountNumber);
                    Account toAccount = bank.getAccount(toAccountNumber);

                    if (fromAccount != null && toAccount != null) {
                        boolean success = fromAccount.transfer(toAccount, password, amount);
                        if (success) {
                            System.out.println("이체 후 잔액: " + fromAccount.getBalance());
                        } else {
                            System.out.println("이체 실패: 비밀번호 오류 또는 잔액 부족");
                        }
                    } else {
                        System.out.println("계좌를 찾을 수 없거나 입력이 잘못되었습니다.");
                    }
                }
                case 0 -> { // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private static String getStringInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.next();
    }

    private static int getIntInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }

    private static int selectMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 계좌 생성");
        System.out.println("2. 계좌 조회");
        System.out.println("3. 입금 ");
        System.out.println("4. 이체");
        System.out.println("0. 종료");
        return sc.nextInt();
    }

}