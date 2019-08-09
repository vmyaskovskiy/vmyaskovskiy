package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.School;
import ru.job4j.lyambda.StudentStr;

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
    @Test
    public void testStudentStr() {
        School school = new School();
        List<StudentStr> strs = Arrays.asList(
                new StudentStr("Petr", 20),
                new StudentStr("Petr", 10),
                new StudentStr("Slava", 10),
                new StudentStr("Vadim", 20),
                new StudentStr("Viktor", 20),
                null,
                new StudentStr("Slava", 30),
                new StudentStr("Sergey", 20),
                new StudentStr("Dima", 40)
        );
        List<StudentStr> res = school.levelOf(strs, 20);
        assertThat(res.size(), Is.is(2));
        List<StudentStr> res1 = school.levelOfNew(strs, 20);
        assertThat(res1.size(), Is.is(4));
        List<StudentStr> res3 = school.levelOfNewOne(strs, 20);
        assertThat(res3.size(), Is.is(4));
    }
}
