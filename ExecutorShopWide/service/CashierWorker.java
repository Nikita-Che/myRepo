package ExecutorShopWide.service;
import ExecutorShopWide.entity.*;
import ExecutorShopWide.util.Randomizer;
import ExecutorShopWide.util.Sleeper;

import java.util.concurrent.Callable;

public class CashierWorker implements Callable<Double> {
    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public Double call() throws Exception {
        System.out.println(cashier + " opened");
        Dispather dispather = store.getDispather();
        QueueCustomer queueCustomer = store.getQueueCustomer();

        while (!dispather.storeClosed()) {
            Customer customer = queueCustomer.pool();
            if (customer != null) {
                System.out.println(cashier + " started serve " + customer);
                int timeout = Randomizer.get(2000, 5000);
                Sleeper.sleep(timeout);
                System.out.println(cashier + " finished serve " + customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.getMonitor().notify();
                }
            } else {
                synchronized (queueCustomer) {
                    queueCustomer.wait(100);
                }
            }
        }
        System.out.println(cashier + " closed");
        return null;
    }
}
