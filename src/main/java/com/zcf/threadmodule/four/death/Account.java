package com.zcf.threadmodule.four.death;

public class Account {
    private String accountName;
    private int balence;

    public Account(String accountName, int balence) {
        this.accountName = accountName;
        this.balence = balence;
    }

    public void debit(int amount) {
        balence -= amount;
    }

    public void credit(int amount) {
        balence += amount;
    }

    public int getBalence() {
        return balence;
    }

    public String getAccountName() {
        return accountName;
    }
}
