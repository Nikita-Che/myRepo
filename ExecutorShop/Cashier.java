package com.company;

import java.util.concurrent.Callable;

public class Cashier implements Callable<Integer> {
    private final String name;

    public Cashier(int number) {
        name = " Cashier " + number;
    }

    int count = 0;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(this + " стартовар");

        while (Queeueee.getCount() > 0) {
            Customer customer = Queeueee.poll();
            System.out.println(this + " начал обслуживать " + customer);
            Util.sleep(Util.rnd(400, 2000));
            System.out.println(this + " завершил обслуживать " + customer);

            synchronized (customer.getMonitor()){
                customer.getMonitor().notify();
            }
            count++;

        }
        System.out.println(this + " финишировал");

        return count;
    }


}
