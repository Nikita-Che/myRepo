package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader;

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = bufferedReader.readLine();
        return line;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        com.javarush.task.task27.task2712.ConsoleHelper.writeMessage("Please choose a dish from the list:" + Dish.allDishesToString() + "\n or type 'exit' to complete the order");
        while (true) {
            String dishName = com.javarush.task.task27.task2712.ConsoleHelper.readString().trim();
            if ("exit".equals(dishName)) {
                break;
            }

            try {
                Dish dish = Dish.valueOf(dishName);
                dishes.add(dish);
                writeMessage(dishName + " has been successfully added to your order");
            } catch (Exception e) {
                writeMessage(dishName + " нет блять такова блюда в ресторане уёбок!");
            }
        }

        return dishes;
    }


}
