package ru.job4j.lyambda;

public class Student {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
    public String getName() {
        return this.name;
    }
}
