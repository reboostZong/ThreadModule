package com.zcf.threadmodule.three.question;

import java.io.File;

public class CountPlus implements Runnable{
    static boolean stop = false;
//   4、 static volatile boolean stop = false;
    static int count = 0;
//    static volatile int count = 0;  防止指令重排序

    public static void main(String[] args) {
        Thread t = new Thread(new CountPlus());
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            count++;
//            System.out.print("");    synchronized + IO
//            1、
//            synchronized (CountPlus.class) {
//
//            }

//            2、
//            new File("1.txt");

//            3、
//            try {
//                Thread.sleep(0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("rs: " + count);

    }
}
