package ru.job4j.lsp;

public class TestStore {
    public static void main(String[] args) {
        Milk milk = new Milk("домик", "01.01.2020", "01.01.2020", 80, 10);
        Apple apple = new Apple("сезонное", "01.01.2020", "01.01.2020", 200, 20);

        Store store = new Store();
        store.add(milk);
        store.add(apple);
        ControllQuality controllQuality = new ControllQuality(store);
        controllQuality.controllQuality();
        for(Food food: store.getArrayList()) {
            System.out.println(food.getName() + "  " + food.getDisscount());
        }
    }
}
