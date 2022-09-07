package ExecutorShopWide.entity;

public class Customer {
    private final String name;

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    private boolean waiting;

    public Object getMonitor () {
        return this;
    }

    public Customer(int number) {
        this.name ="Customer #"+ number ;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
