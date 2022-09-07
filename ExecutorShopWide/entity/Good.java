package ExecutorShopWide.entity;

public class Good {

    private final String name;
    private final double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Good() {
        this("undefined good" , 10.0);
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
