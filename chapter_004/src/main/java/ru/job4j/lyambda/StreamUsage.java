package ru.job4j.lyambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        public String toString() {
            return name + " " + spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Bug", 100),
                new Task("Task", 100)
        );

    List<Task> contain = new ArrayList<>();
    for (Task task: tasks) {
        if ("Bug".contains(task.name)) {
            contain.add(task);
        }
    }
    List<String> names = new ArrayList<>();
    for (Task task: tasks) {
        names.add(task.name);
    }


    Long total = 0L;
    for (Task task : tasks) {
        total += task.spent;
    }

    Long totalTwo = tasks.stream().map(
            task -> task.spent
    ).reduce(0L, Long :: sum);

    List<Task> bugs = tasks.stream().filter(
            task -> task.name.contains("Bug")
    ).collect(Collectors.toList());

    List<String> namesTwo = tasks.stream().map(
            task -> task.name
    ).collect(Collectors.toList());

        System.out.println(contain);
        System.out.println(bugs);
        System.out.println(names);
        System.out.println(namesTwo);
        System.out.println(total);
        System.out.println(totalTwo);
    }




}
