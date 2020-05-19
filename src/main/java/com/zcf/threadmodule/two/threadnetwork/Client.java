package com.zcf.threadmodule.two.threadnetwork;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int maxSize = 5;
        Thread p = new Thread(new Producter(queue, maxSize));
        Thread c = new Thread(new Consumer(queue, maxSize));
        p.start();
        c.start();
    }
}
