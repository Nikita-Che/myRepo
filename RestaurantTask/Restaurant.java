package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {

    public static void main(String[] args) throws IOException {

        Tablet tablet = new Tablet(1);
        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
        Cook cook = new Cook("Povar Pidor");
        Waiter waiter = new Waiter();
        tablet.addObserver(cook);
        cook.addObserver(waiter);
    }
}
