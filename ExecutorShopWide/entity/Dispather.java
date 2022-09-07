package ExecutorShopWide.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispather {

    private final int countCustomer;
    private final AtomicInteger countInCustomer = new AtomicInteger(0);
    private final AtomicInteger countOutCustomer = new AtomicInteger(0);

    public Dispather(int countCustomer) {
        this.countCustomer = countCustomer;
    }

    public synchronized void enterCustomer () {
        countInCustomer.getAndIncrement();
    }

    public synchronized void leaveCustormer () {
        countOutCustomer.getAndIncrement();
    }

    public boolean storeOpened() {
        return countInCustomer.get() != countCustomer;
    }

    public boolean storeClosed() {
        return countOutCustomer.get() == countCustomer;
    }
}
