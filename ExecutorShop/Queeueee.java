package com.company;

import java.util.ArrayDeque;
import java.util.Queue;

public class Queeueee {
    private static Queue<Customer> customerQueue = new ArrayDeque<>();

    static synchronized void add(Customer customer) {
        customerQueue.add(customer);
    }

    static synchronized Customer poll() {
        return customerQueue.poll();
    }

    static synchronized int getCount () {
        return customerQueue.size();
    }


}
