package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static int N_THREADS = 4;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Store Open");

        ExecutorService executorCustomers = Executors.newFixedThreadPool(N_THREADS);
        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer(i);
            Util.sleep(Util.rnd(100,300));
            executorCustomers.execute(customer);
        }

        Util.sleep(3000);
        ExecutorService executorCashiers = Executors.newFixedThreadPool(N_THREADS);
        List<Cashier> cashiers = new ArrayList<>();
        cashiers.add(new Cashier(1));
        cashiers.add(new Cashier(2));

        List<Future<Integer>> futures = executorCashiers.invokeAll(cashiers);
        executorCashiers.shutdown();
        for (Future<Integer> future : futures) {
            System.out.println("count " + future.get());
        }

        executorCustomers.shutdown();
        while (!executorCustomers.awaitTermination(1,TimeUnit.MINUTES)) {
            System.out.println("one minute left");
        }

        System.out.println("Store Close");


    }
}