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

    public void subtractAmountFromBalance(int amount) {
        this.balance -= amount;
    }

    public void addAmountToBalance(int amount) {
        this.balance += amount;
    }
}
