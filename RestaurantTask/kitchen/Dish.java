package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

    public static String allDishesToString() {
        String fish = FISH.toString();
        String steak = STEAK.toString();
        String soup = SOUP.toString();
        String juice = JUICE.toString();
        String water = WATER.toString();

        return fish + " " + steak + " " + soup + " " + juice + " " + water;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
