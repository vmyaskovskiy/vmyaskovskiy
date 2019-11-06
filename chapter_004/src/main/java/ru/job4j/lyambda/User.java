package ru.job4j.lyambda;

public class User extends Base {
    private String name;
    public User(String id, String name) {
        super(id);
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return "name " + this.name;
    }
}
