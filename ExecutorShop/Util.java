package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    static int rnd (int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    static void sleep (int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
