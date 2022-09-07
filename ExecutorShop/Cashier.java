package com.company;

import java.util.concurrent.Callable;

public class Cashier implements Callable<Integer> {
    private final String name;

    public Cashier(int number) {
        name = "Cashier " + number;
    }

    int count = 0;

    @Override
    public Integer call() throws Exception {
        System.out.println(this + " started work");

        while (Queeueee.getCount() > 0) {
            Customer customer = Queeueee.poll();
            System.out.println(this + " started serve customer " + customer);
            Util.sleep(Util.rnd(400, 2000));
            System.out.println(this + " finished serve customer " + customer);

            synchronized (customer.getMonitor()){
                customer.getMonitor().notify();
            }
            count++;

        }
        System.out.println(this + " finished work");
        return count;
    }

    @Override
    public String toString() {
        return name;
    }


}
