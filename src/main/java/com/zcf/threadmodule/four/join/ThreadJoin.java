package com.zcf.threadmodule.four.join;

public class ThreadJoin {
    private static int i = 10;
    public static void main(String[] args) throws InterruptedException {
        Thread t =new Thread(()->{
            i = 30;
        });
        t.start();

        t.join();
        System.out.println("i: " + i);
    }
}
