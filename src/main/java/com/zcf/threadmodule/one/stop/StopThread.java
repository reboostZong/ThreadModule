package com.zcf.threadmodule.one.stop;

import java.util.concurrent.TimeUnit;

/**
 * 暴力关闭线程
 */
public class StopThread implements Runnable{
    public static void main(String[] args) {
        Thread t = new Thread(new StopThread());
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //暴力关闭线程
        t.stop();
    }


    @Override
    public void run() {
        while (true) {
            System.out.println("线程开始循环");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
