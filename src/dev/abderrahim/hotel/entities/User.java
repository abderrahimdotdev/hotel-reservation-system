package dev.abderrahim.hotel.entities;

public class User {
    private int id;
    private int balance;

    public User(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int newBalance) {
        if(newBalance < 0){
            System.err.println("Balance cannot be negative.");
            return;
        }
        this.balance = newBalance;
    }
}
