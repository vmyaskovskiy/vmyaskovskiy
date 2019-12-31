package ru.job4j.lyambda;

import java.util.*;

public class UserMap {
    String name;
    int children;
    Calendar birthday;
    public UserMap (String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public Calendar calendar() {
        return this.birthday;
    }
    @Override
    public String toString() {
        return "name " + this.name +
                ", children " + this.children +
                ", birthday " + this.birthday.getTime();
    }
}
