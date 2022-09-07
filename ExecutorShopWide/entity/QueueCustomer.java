package ExecutorShopWide.entity;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueCustomer {

    private final Deque<Customer> deque = new ConcurrentLinkedDeque<>();

    public void add (Customer customer) {
        deque.addLast(customer);
    }

    public Customer pool () {
        return deque.pollFirst();
    }

}
