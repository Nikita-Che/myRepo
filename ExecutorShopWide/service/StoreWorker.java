package ExecutorShopWide.service;

import ExecutorShopWide.entity.Cashier;
import ExecutorShopWide.entity.Customer;
import ExecutorShopWide.entity.Dispather;
import ExecutorShopWide.entity.Store;
import ExecutorShopWide.util.Randomizer;
import ExecutorShopWide.util.Sleeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread {

    private final Store store;
    public static final int N_THREADS = 10;
    public static final int COUNT_CHASHIERS = 2;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(store + " opened ");

        Dispather dispather = store.getDispather();

        ExecutorService executorCashiers = Executors.newFixedThreadPool(COUNT_CHASHIERS);
        for (int cushierCounter = 1; cushierCounter <= COUNT_CHASHIERS; cushierCounter++) {
            Cashier cashier = new Cashier(cushierCounter);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            executorCashiers.submit(cashierWorker);
        }

        ExecutorService executorCustomer = Executors.newFixedThreadPool(N_THREADS);
        int customerCouner = 0;
        while (dispather.storeOpened()) {
            int count = Randomizer.get(3);
            for (int i = 0; dispather.storeOpened() && i <= count; i++) {
                customerCouner++;
                Customer customer = new Customer(customerCouner);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                executorCustomer.submit(customerWorker);
            }
            Sleeper.sleep(1000);
        }

        executorCustomer.shutdown();
        executorCashiers.shutdown();

        while (!store.getDispather().storeClosed()) {
            try {
                executorCashiers.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(store + " closed ");

    }

}
