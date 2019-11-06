package ru.job4j.lyambda;

public class Role extends Base {
    protected String description;
    public Role(String id, String description) {
        super(id);
        this.description = description;
    }
    @Override
    public String toString() {
        return "name " + this.description;
    }
    public String getDescription() {
        return this.description;
    }
}
