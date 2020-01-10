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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMap userMap = (UserMap) o;
        return children == userMap.children &&
                name.equals(userMap.name) &&
                birthday.equals(userMap.birthday);
    }

    @Override
    public int hashCode() {
       return 31 * 1 +
               name.hashCode() +
               children +
               birthday.getTime().hashCode();
    }

    @Override
    public String toString() {
        return "name " + this.name +
                ", children " + this.children +
                ", birthday " + this.birthday.getTime();
    }
}
