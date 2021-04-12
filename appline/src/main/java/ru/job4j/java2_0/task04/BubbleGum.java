package ru.job4j.java2_0.task04;

public class BubbleGum extends Sweets {
    private String size;
    public BubbleGum(String name, int weight, double cost, String size) {
        super(name, weight, cost, size);
       // this.size = size;
    }
    public String getSize() {
        return this.size;
    }
}
