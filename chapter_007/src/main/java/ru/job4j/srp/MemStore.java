package ru.job4j.srp;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {

    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {

        List<Employee> list = employees.stream().filter(filter).collect(Collectors.toList());
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                Integer s1 = (int) o1.getSalary();
                Integer s2 = (int) o2.getSalary();
                return s1.compareTo(s2);

            }
        });
        return list;
    }
}

