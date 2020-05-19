package com.zcf.threadmodule.two.threadnetwork;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Producter implements Runnable {
    private Queue<String> queue;
    private int maxSize;

    public Producter(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (queue) {

                    while (queue.size() == maxSize) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    queue.add("生产者 生产：" + i);
                    System.out.println("生产者 生产：" + i);
                    queue.notify();
                }

        }

    }
}
