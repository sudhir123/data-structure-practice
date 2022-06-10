package com.prac.home.tests;

public class AccountTest {
    public static void main(String[] args) {

    }
}

class Account{
    double amount;

    public void deposit(double amount){
        System.out.println();
        //
        synchronized (this){
            this.amount= this.amount- amount;
        }
        System.out.println();
    }

    public void withdraw(double amount){
        System.out.println();
        //
        synchronized (this){
            this.amount= this.amount+ amount;
        }
    }
}