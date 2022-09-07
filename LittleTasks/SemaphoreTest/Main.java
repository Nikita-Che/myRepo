package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SemaphorDemo.Run("Stream " + i));
        }
        executorService.shutdown();
        try {
            executorService.execute(new SemaphorDemo.Run(" Stream #999 "));
        } catch (RejectedExecutionException rejectedExecutionException) {
            System.out.println("error starting Stream #999");
        }
        System.out.println(" All streams added ");
    }

    public class SemaphorDemo {
        private static final Semaphore semaphore = new Semaphore(4);

        private static class Run implements Runnable {
            private final String name;

            private Run(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                System.out.println(" getting control ");

                try {
                    semaphore.acquire();
                    System.out.println("-- " + name + " started");
                    Thread.sleep(1000);
                    System.out.println("-- " + name + " closed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }

    }
}