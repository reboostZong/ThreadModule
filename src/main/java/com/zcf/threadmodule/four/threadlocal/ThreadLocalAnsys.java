package com.zcf.threadmodule.four.threadlocal;

public class ThreadLocalAnsys {
    private static int num = 0;
     static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
//                num += 5;
                Integer num = threadLocal.get();
                threadLocal.set(num+=5);
                System.out.println("num: " + threadLocal.get());
//                System.out.println("num: " + num);
            });
            threads[i] = thread;
        }

        for (int i = 0; i < 5; i++) {
            threads[i].start();

        }
    }
}
