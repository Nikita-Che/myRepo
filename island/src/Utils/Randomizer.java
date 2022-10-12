package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static int getRandomNumber() {
        int number = ThreadLocalRandom.current().nextInt(0,10);
        return number;
    }
}
