package com.zcf.threadmodule.two.classlayout;

import org.openjdk.jol.info.ClassLayout;

public class LockExpand {
    public static void main(String[] args) {
        LockExpand lock = new LockExpand();
        Thread t = new Thread(()->{
            synchronized (lock) {
                System.out.println("线程t 获取到锁");
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        });
        t.start();

        synchronized (lock) {
            System.out.println("主线程 获取到锁");
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }
    }
}
