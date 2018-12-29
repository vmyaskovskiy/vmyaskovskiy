package ru.job4j.array;

public class User {
    private int id;
    private String name;
    private String City;

    public User (int id, String name, String City) {
        this.id = id;
        this.name = name;
        this.City = City;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return City;
    }
}