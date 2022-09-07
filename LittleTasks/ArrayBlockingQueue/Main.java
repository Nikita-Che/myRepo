package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(12);

        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 15; i++) {
                    try {
                        queue.put("Java");
                        System.out.println("element " + i + " added");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(2000);
                        System.out.println("Element " + queue.take() + " taken");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}