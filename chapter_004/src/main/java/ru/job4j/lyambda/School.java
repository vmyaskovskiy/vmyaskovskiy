package ru.job4j.lyambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.sort;


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
    public List<StudentStr> levelOf(List<StudentStr> studentStrs, int bound) {
        List<StudentStr> res1 = studentStrs.stream().
                flatMap(Stream::ofNullable).
                sorted().
                dropWhile(studentStr -> studentStr.getScope() == bound).
                collect(Collectors.toList());
         return res1;
    }
}
