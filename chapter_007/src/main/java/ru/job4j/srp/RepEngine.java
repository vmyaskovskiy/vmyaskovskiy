package ru.job4j.srp;

import java.util.function.Predicate;

public interface RepEngine {
    String generate(Predicate<Employee> filter);
}
