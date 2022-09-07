package com.company;

public class Customer extends Thread {

    private Object monitor = this;

    public Object getMonitor() {
        return monitor;
    }

    public Customer(int number) {
        super("Customer " + number);
    }

    @Override
    public void run() {
        System.out.println(this + " went to store");
        int rnd = Util.rnd(500, 1500);
        Util.sleep(rnd);
        System.out.println(this + " went to queue");
        Queeueee.add(this);
        synchronized (getMonitor()){
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " leave store");
    }

    @Override
    public String toString() {
        return getName();
    }
}
