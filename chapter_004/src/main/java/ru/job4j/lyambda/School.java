package ru.job4j.lyambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class School {
    public static class Student {
        public final int score;

        public Student(int score) {
            this.score = score;
        }
        @Override
        public String toString() {
            return "score" + score;
        }
    }
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        List<Student> res = new ArrayList<>();
        for (Student student : students) {
            if (predicate.test(student)) {
                res.add(student);
            }
        }
        return res;
    }
}
