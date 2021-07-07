package ru.job4j.lsp;

import java.util.*;

public class TestStore {


    public static void main(String[] args)  {

        // 90% свежее в Warehouse
        Milk milk = new Milk("домик", "30.12.2020", "20.11.2020", 80, 10);
        // Если срок годности от 25% до 75% направить в Shop
        Apple apple = new Apple("сеонное", "20.12.2020", "15.11.2020", 180, 10);
        // Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
        Milk milk1 = new Milk("Простоквашино", "07.12.2020", "20.11.2020", 80, 10);
        // Если срок годности вышел. Отправить продукт в мусорку.
        Apple apple1 = new Apple("red", "17.11.2020", "15.11.2020", 190, 10);
        Apple apple2 = new Apple("redNew", "17.11.2021", "15.11.2020", 200, 10);

        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();

        List<Store> stores = new ArrayList<>();
        stores.add(shop);
        stores.add(warehouse);
        stores.add(trash);

        ArrayList<Food> storeFood = new ArrayList<>();
        storeFood.add(milk);
        storeFood.add(milk1);
        storeFood.add(apple);
        storeFood.add(apple1);
        storeFood.add(apple2);

        ControllQuality controllQuality = new ControllQuality(stores, storeFood);
        controllQuality.execute();

        for(Food food: shop.getArrayList()){
        System.out.println("shop " + food.getName() + "  " + food.getDisscount());
        }

        for(Food food: warehouse.getArrayList()){
            System.out.println("warehouse " + food.getName() + "  " + food.getDisscount() );
        }

        for(Food food: trash.getArrayList()){
            System.out.println("trash " + food.getName() + "  " + food.getDisscount() );
        }

        controllQuality.resort();


        for(Food food: shop.getArrayList()){
            System.out.println("shop " + food.getName() + "  " + food.getDisscount());
        }

        for(Food food: warehouse.getArrayList()){
            System.out.println("warehouse " + food.getName() + "  " + food.getDisscount() );
        }

        for(Food food: trash.getArrayList()){
            System.out.println("trash " + food.getName() + "  " + food.getDisscount() );
        }
    }
}
