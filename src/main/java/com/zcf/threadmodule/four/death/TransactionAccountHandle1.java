package com.zcf.threadmodule.four.death;

public class TransactionAccountHandle1 implements Runnable{
    private Account fromAccount;
    private Account toAccount;
    private int amount;
    private Allocator allocator;

    public TransactionAccountHandle1(Account fromAccount, Account toAccount, int amount, Allocator allocator) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator = allocator;
    }

    @Override
    public void run() {
        while (true) {
            if (allocator.applyLock(fromAccount, toAccount)) {//同时获取两把锁的if改造
                try {
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
                } finally {
                    allocator.removeLock(fromAccount, toAccount);
                }
            }
        }
    }

    public static void main(String[] args) {
        Account from = new Account("Mic", 100000);
        Account to =new Account("花花", 300000);
        Allocator allocator = new Allocator();

        TransactionAccountHandle1 transactionAccount1 = new TransactionAccountHandle1(from, to, 10, allocator);
        TransactionAccountHandle1 transactionAccount2 = new TransactionAccountHandle1(to, from, 30, allocator);
        Thread t1 = new Thread(transactionAccount1);
        Thread t2 = new Thread(transactionAccount2);

        t1.start();
        t2.start();

    }
}
