package ru.job4j.lsp;

import java.util.ArrayList;

public class TestStore {
    public static void main(String[] args) {
        ControllQuality controllQuality = new ControllQuality();
        Milk milk = new Milk("домик", "01.01.2020", "01.01.2020", 80, 10);
        Apple apple = new Apple("сезонное", "01.01.2020", "01.01.2020", 180, 20);
        ArrayList<Food> store = new ArrayList<>();
        store.add(milk);
        store.add(apple);

        for(Food food: store) {
            controllQuality.controllQuality(food);
        }

        for(Food food: controllQuality.getWarehouse().getArrayList()){
        System.out.println(food.getName() + "  " + food.getDisscount());
        }

        for(Food food: controllQuality.getShop().getArrayList()){
            System.out.println(food.getName() + "  " + food.getDisscount());
        }
    }
}
