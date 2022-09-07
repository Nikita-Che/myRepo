package ExecutorShopWide.entity;

public class Store {
    private final String name;
    private final Dispather dispather;
    private final QueueCustomer queueCustomer;

    public QueueCustomer getQueueCustomer() {
        return queueCustomer;
    }

    public Dispather getDispather() {
        return dispather;
    }

    public Store(String name, Dispather dispather, QueueCustomer queueCustomer) {
        this.name = name;
        this.dispather = dispather;
        this.queueCustomer = queueCustomer;
    }

    @Override
    public String toString() {
        return name;
    }
}
