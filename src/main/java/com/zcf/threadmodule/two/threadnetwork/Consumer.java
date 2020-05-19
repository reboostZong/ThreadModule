package com.zcf.threadmodule.two.threadnetwork;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<String> queue;
    private int maxSize;

    public Consumer(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {

                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("消费者 消费：" + queue.remove());
                queue.notify();
            }
        }
    }
}
