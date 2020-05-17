package com.zcf.threadmodule.one.define;

import java.util.concurrent.TimeUnit;

public class RunnableDefine implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(new RunnableDefine());
        t.start();
        System.out.println("Main-end ...");
    }
}
