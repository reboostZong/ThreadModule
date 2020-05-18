package com.zcf.threadmodule.two.classlayout;

public class ClassLayout {
    public static void main(String[] args) {
        ClassLayout classLayout = new ClassLayout();
        //1、打印类布局,无锁状态
//        System.out.println(org.openjdk.jol.info.ClassLayout.parseInstance(classLayout).toPrintable());

        //2、打印类布局, 加锁，但没有锁竞争
        synchronized (classLayout) {
            System.out.println(org.openjdk.jol.info.ClassLayout.parseInstance(classLayout).toPrintable());
        }
    }
}
