package com.zcf.threadmodule.one.stop;

import java.util.concurrent.TimeUnit;

/**
 * 这种方式可以关闭线程
 * 但不能及时关闭
 */
public class FlagStopThread implements Runnable {
    //volatile关键字保证内存可见性
    private static volatile boolean isStop = false;

    @Override
    public void run() {
        while (!isStop) {
            System.out.println("线程开始循环");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new FlagStopThread());
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //标志位方式关闭线程
        isStop = true;

    }
}
