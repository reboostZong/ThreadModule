package com.zcf.threadmodule.four.death;

public class TransactionAccount implements Runnable{
    private Account fromAccount;
    private Account toAccount;
    private int amount;

    public TransactionAccount(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    if (fromAccount.getBalence() >= amount) {
                        fromAccount.debit(amount);
                        toAccount.credit(amount);

                        System.out.println(fromAccount.getAccountName() + "->" + fromAccount.getBalence());
                        System.out.println(toAccount.getAccountName() + "->" + toAccount.getBalence());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Account from = new Account("Mic", 100000);
        Account to =new Account("花花", 300000);

        TransactionAccount transactionAccount1 = new TransactionAccount(from, to, 10);
        TransactionAccount transactionAccount2 = new TransactionAccount(to, from, 30);
        Thread t1 = new Thread(transactionAccount1);
        Thread t2 = new Thread(transactionAccount2);

        t1.start();
        t2.start();

    }
}
