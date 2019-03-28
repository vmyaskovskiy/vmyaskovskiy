package ru.job4j.array;

import java.util.Objects;

public class UserForBank {
    private String name;
    private String passport;

    public UserForBank(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }
    public String getPassport() {
        return passport;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserForBank userForBank = (UserForBank) o;
        return //Objects.equals(name, userForBank.name)
               // &&
                Objects.equals(passport, userForBank.passport);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, passport);
    }
    @Override
    public String toString() {
        return "User{"
                +
                "Name='"
                + this.name
                + '\''
                +
                ", passport='"
                + this.passport
                +
                '}';
    }
}
