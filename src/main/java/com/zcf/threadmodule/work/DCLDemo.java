package com.zcf.threadmodule.work;

public class DCLDemo {
    private DCLDemo() {

    }

    private volatile static DCLDemo instance;

    public static DCLDemo getInstance() {
        if (instance == null) {
            synchronized (DCLDemo.class) {
                if (instance == null) {
                    instance = new DCLDemo();
                }
            }
        }
        return instance;
    }
}
