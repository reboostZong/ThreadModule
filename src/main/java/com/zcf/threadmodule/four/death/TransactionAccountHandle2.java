package com.zcf.threadmodule.four.death;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionAccountHandle2 implements Runnable{
    private Account fromAccount;
    private Account toAccount;
    private int amount;
    private Lock fromLock =new ReentrantLock();
    private Lock toLock =new ReentrantLock();

    public TransactionAccountHandle2(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }


    @Override
    public void run() {
        while (true) {//使用lock.tryLock()的if改造
            if (fromLock.tryLock()) {
                if (toLock.tryLock()) {
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

        TransactionAccountHandle2 transactionAccount1 = new TransactionAccountHandle2(from, to, 10);
        TransactionAccountHandle2 transactionAccount2 = new TransactionAccountHandle2(to, from, 30);
        Thread t1 = new Thread(transactionAccount1);
        Thread t2 = new Thread(transactionAccount2);

        t1.start();
        t2.start();

    }
}
