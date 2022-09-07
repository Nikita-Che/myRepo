package ExecutorShopWide.service;

import ExecutorShopWide.entity.Customer;
import ExecutorShopWide.entity.Store;
import ExecutorShopWide.exeption.StoreException;
import ExecutorShopWide.interfaces.CustomerAction;
import ExecutorShopWide.entity.Dispather;
import ExecutorShopWide.entity.QueueCustomer;
import ExecutorShopWide.util.Randomizer;
import ExecutorShopWide.util.Sleeper;

public class CustomerWorker implements Runnable, CustomerAction {
    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        Dispather dispather = store.getDispather();
        dispather.enterCustomer();
    }

    @Override
    public void run() {
        enterToStore();
        chooseGoods();
        goTOQueue();
        leavesToStore();

        Dispather dispather = store.getDispather();
        dispather.leaveCustormer();
    }

    @Override
    public void enterToStore() {
        System.out.println(customer + " enter to " + store);
    }

    @Override
    public void leavesToStore() {

    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    @Override
    public void goTOQueue() {
        QueueCustomer queueCustomer = store.getQueueCustomer();
        Object monitor = customer.getMonitor();
        synchronized (monitor) {
            queueCustomer.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new StoreException();
                }
            }
        }
    }

    @Override
    public void chooseGoods() {
        System.out.println(customer + " started choose goods ");
        int timeout = Randomizer.get(1000, 3000);
        Sleeper.sleep(timeout);
        System.out.println(customer + " finished choose goods ");
    }
}
