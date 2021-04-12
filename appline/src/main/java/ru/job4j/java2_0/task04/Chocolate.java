package ru.job4j.java2_0.task04;

public class Chocolate extends Sweets {
    private String color;
    public Chocolate(String name, int weight, double cost, String color) {
        super(name, weight, cost, color);
        //this.color = color;
    }
    public String getColor() {
        return this.color;
    }
}
