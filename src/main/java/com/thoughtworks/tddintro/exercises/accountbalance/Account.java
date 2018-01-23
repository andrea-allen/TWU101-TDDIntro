package com.thoughtworks.tddintro.exercises.accountbalance;

public class Account {
    private int balance;

    public Account(){

    }

    public Account(int i){
        this.balance=i;
    }

    public void deposit(int i){
        setBalance(this.getBalance()+i);
    }

    public void withdraw(int i){

    }

    public int getBalance(){
        return this.balance;
    }

    public void setBalance(int i){
        this.balance=i;
    }
}
