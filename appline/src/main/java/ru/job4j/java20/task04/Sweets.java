package ru.job4j.java20.task04;

public class Sweets {
    private int weight;
    private String name;
    private double cost;
    private String param;
    public Sweets(String name, int weight, double cost, String param) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.param = param;
    }

    public String getName() {
        return this.name;
    }
    public int getWeight() {
        return this.weight;
    }
    public double getCost() {
        return this.cost;
    }
    public String getParam() {
        return this.param;
    }
}
