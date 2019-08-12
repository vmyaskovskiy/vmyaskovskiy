package ru.job4j;
import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.Student;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestStudent {
    @Test
    public void convertToMap() {
        List<Student> students = List.of(
                new Student("Slava", 10),
                new Student("Petr", 15),
                new Student("Miha", 50),
                new Student("Serega", 60),
                new Student("Sasha", 70),
                new Student("Masha", 75),
                new Student("Sveta", 100)
        );
        Map<String, Student> studentMap =
                students.stream().
                        collect(Collectors.toMap(Student::getName, Student -> Student));
        assertThat(studentMap.get(students.get(0).getName()), Is.is(students.get(0)));
    }
}
