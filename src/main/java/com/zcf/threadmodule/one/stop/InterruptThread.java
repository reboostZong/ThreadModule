package com.zcf.threadmodule.one.stop;

import java.util.concurrent.TimeUnit;

/**
 * 这种方式可以及时关闭线程，以Interrupt异常的方式
 * 但中断信号会复位
 */
public class InterruptThread implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("线程开始循环");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                //抛出Interrupt异常后，中断信号复位
                //此时，需要主动处理中断情况
                Thread.currentThread().interrupt();
            }
        }
    }

//    @Override
//    public void run() {
//        while (!Thread.currentThread().isInterrupted()) { //判断中断的条件
//            System.out.println("线程开始循环");
//        }
//    }

    public static void main(String[] args) {
        Thread t = new Thread(new InterruptThread());
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
