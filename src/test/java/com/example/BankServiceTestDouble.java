package com.example;

public class BankServiceTestDouble implements BankService {
    public boolean isPaid = false;
    @Override
    public void pay(String employeeId, double amount) {
        isPaid = true;
    }
}