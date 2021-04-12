package ru.job4j.java2_0.task04;

public class Candy extends Sweets {
    private String wrapper;
    public Candy(String name, int weight, double cost, String wrapper) {
        super(name, weight, cost, wrapper);
        //this.wrapper = wrapper;
    }
    public String getWrapper() {
        return this.wrapper;
    }
}
