package com.zcf.threadmodule.five.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockClient {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->ReentrantLockClient.increase()).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count: " + count);

    }

    public  static void increase() {
        lock.lock();
        try {
            Thread.sleep(1);
            count++;
            decrease();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void decrease() {
        lock.lock();
        try {
            Thread.sleep(1);
            count--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
