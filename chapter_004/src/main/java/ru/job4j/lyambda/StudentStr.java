package ru.job4j.lyambda;

import java.util.*;

public class StudentStr implements Comparable<StudentStr> {
    private String name;
    private int scope;
    public StudentStr(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }
    public int compareTo(StudentStr o1) {
            return Integer.compare(this.scope, o1.scope);
    }
    @Override
    public String toString() {
        return "Name " + this.name + " " + this.scope;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentStr studentStr = (StudentStr) o;
        return Objects.equals(name, studentStr.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    public int getScope() {
        return this.scope;
    }
}
