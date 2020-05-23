package com.zcf.threadmodule.work;

import java.io.IOException;

public class SynchronizedDemo {
    static Integer count = 0;
    static Object obj = new Object();

    public static void incr() {

        synchronized (count) {

            try {

                Thread.sleep(1);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            count++;

        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 1000; i++) {

            new Thread(() -> SynchronizedDemo.incr()).start();

        }

        Thread.sleep(5000);

        System.out.println("result:" + count);

    }
}
