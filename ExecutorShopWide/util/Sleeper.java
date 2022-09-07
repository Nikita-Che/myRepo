package ExecutorShopWide.util;

import ExecutorShopWide.exeption.StoreException;

public class Sleeper {

    private Sleeper() {
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/100);
        } catch (InterruptedException e) {
            throw new StoreException(e);
        }
    }


}
