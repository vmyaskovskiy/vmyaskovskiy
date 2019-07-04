package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.School;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;

public class TestSchool {
    @Test
    public void test10A() {
        List<School.Student> students = Arrays.asList(
                new School.Student(10),
                new School.Student(15),
                new School.Student(50),
                new School.Student(60),
                new School.Student(70),
                new School.Student(75),
                new School.Student(100)
        );
        List<School.Student> res1 = students.stream().filter(student -> student.score > 70 && student.score <= 100).collect(Collectors.toList());
        assertThat(res1.size(), Is.is(2));
    }
    @Test
    public void test10B() {
        List<School.Student> students = Arrays.asList(
                new School.Student(10),
                new School.Student(50),
                new School.Student(60),
                new School.Student(70),
                new School.Student(75),
                new School.Student(100)
        );
        List<School.Student> res1 = students.stream().filter(student -> student.score > 50 && student.score <= 70).collect(Collectors.toList());
        assertThat(res1.size(), Is.is(2));
    }
    @Test
    public void test10C() {
        List<School.Student> students = Arrays.asList(
                new School.Student(10),
                new School.Student(15),
                new School.Student(50),
                new School.Student(60),
                new School.Student(70),
                new School.Student(75),
                new School.Student(100)
        );
        List<School.Student> res1 = students.stream().filter(student -> student.score >= 10 && student.score <= 50).collect(Collectors.toList());
        assertThat(res1.size(), Is.is(3));
    }
    @Test
    public void test10Anew() {
        School school = new School();
        List<School.Student> students = Arrays.asList(
                new School.Student(10),
                new School.Student(15),
                new School.Student(50),
                new School.Student(60),
                new School.Student(70),
                new School.Student(75),
                new School.Student(100)
        );
        List<School.Student> res = school.collect(students, student -> student.score >= 10 && student.score <= 50);
        List<School.Student> res1 = students.stream().filter(student -> student.score >= 10 && student.score <= 50).collect(Collectors.toList());
        assertThat(res1.size(), Is.is(3));
        assertThat(res.size(), Is.is(3));
    }
}
