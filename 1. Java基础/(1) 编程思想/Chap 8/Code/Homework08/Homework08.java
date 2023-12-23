package com.tybxx.Chap8.Homework08;

public class Homework08 {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(25000);
        ba1.showBanlance();

        BankAccount ba2 = new CheckingAccount(2);
        ba2.showBanlance();
        ba2.deposit(20);
        ba2.showBanlance();
        ba2.withdraw(1);
        ba2.showBanlance();

        BankAccount ba3 = new SavingsAccount(114514, 4, 0.0002);
        ba3.showBanlance();
        ba3.deposit(1);
        ba3.deposit(1);
        ba3.withdraw(2);
        ba3.withdraw(14514);
        ba3.showBanlance();

    }
}

class BankAccount{
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }
    public void showBanlance(){
        System.out.println("The balance is " + this.balance);
    }
}

class CheckingAccount extends BankAccount{
    public CheckingAccount(int balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}

class SavingsAccount extends BankAccount{
    private int months;
    private double interest;
    private int freeDeal = 3;
    public SavingsAccount(int balance, int months, double interest) {
        super(balance);
        this.months = months;
        this.interest = interest;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public void deposit(double amount) {
        if(freeDeal <=0){
            super.deposit(amount - 1);
            return;
        }
        super.deposit(amount);
        freeDeal--;
    }

    public void withdraw(double amount) {
        if(freeDeal <=0){
            super.withdraw(amount + 1);
            return;
        }
        super.withdraw(amount);
        freeDeal--;
    }

    public void earnMonthlyInterst(){
        deposit(months * interest);
    }
}