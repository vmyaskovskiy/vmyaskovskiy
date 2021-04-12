package ru.job4j.java2_0.task04;

import java.util.ArrayList;

public class Box {
    public static void main(String[] args) {

        Candy candy = new Candy("Каракум", 10, 12.3, "paper");
        Chocolate chocolate = new Chocolate("Nestle", 20, 20, "Dark");
        BubbleGum bubbleGum = new BubbleGum("Орбит", 5, 7, "Small");

        ArrayList<Sweets> box = new ArrayList<>();
        box.add(candy);
        box.add(chocolate);
        box.add(bubbleGum);
        int weight = 0;
        double cost = 0;
        System.out.println(" информация о подарке ");
        for(Sweets sw: box) {
            weight = weight + sw.getWeight();
            cost = cost + sw.getCost();
            System.out.println("название: " + sw.getName());
            System.out.println("вес: " + sw.getWeight());
            System.out.println("стоимость: " + sw.getCost());
            System.out.println("параметр: " + sw.getParam());
            System.out.println("----------------");
        }

        System.out.println("общий вес подарка: " + weight + "гр");
        System.out.println("общая стоимость подарка: " +  cost + "руб");

    }
}
