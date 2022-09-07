package ExecutorShopWide;

import ExecutorShopWide.entity.Store;
import ExecutorShopWide.entity.Dispather;
import ExecutorShopWide.entity.QueueCustomer;
import ExecutorShopWide.service.StoreWorker;

public class Runner {

    public static void main(String[] args) {
        QueueCustomer queueCustomer = new QueueCustomer();
        Dispather dispather = new Dispather(100);
        Store store = new Store("MegaStore", dispather, queueCustomer);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}