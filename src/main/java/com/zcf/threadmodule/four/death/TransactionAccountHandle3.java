package com.zcf.threadmodule.four.death;

public class TransactionAccountHandle3 implements Runnable{
    private Account fromAccount;
    private Account toAccount;
    private int amount;

    public TransactionAccountHandle3(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }


    @Override
    public void run() {
        //将锁的方向调一致
        Account left;
        Account right;
        if (fromAccount.hashCode() > toAccount.hashCode()) {
            left = toAccount;
            right = fromAccount;
        } else {
            left = fromAccount;
            right = toAccount;
        }

        while (true) {
            synchronized (left) {
                synchronized (right) {
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

        TransactionAccountHandle3 transactionAccount1 = new TransactionAccountHandle3(from, to, 10);
        TransactionAccountHandle3 transactionAccount2 = new TransactionAccountHandle3(to, from, 30);
        Thread t1 = new Thread(transactionAccount1);
        Thread t2 = new Thread(transactionAccount2);

        t1.start();
        t2.start();

    }
}
