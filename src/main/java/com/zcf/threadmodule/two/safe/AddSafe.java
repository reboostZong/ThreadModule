package com.zcf.threadmodule.two.safe;

import java.util.concurrent.TimeUnit;

public class AddSafe {
    private static int count = 0;

    public static void increse() {
        try {
            //睡眠触发线程切换
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> AddSafe.increse()).start();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
