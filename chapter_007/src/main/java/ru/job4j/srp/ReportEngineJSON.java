package ru.job4j.srp;

import java.util.StringJoiner;
import java.util.function.Predicate;
public class ReportEngineJSON implements RepEngine {
    private Store store;
    public ReportEngineJSON(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {

        StringJoiner textJson = new StringJoiner(System.lineSeparator());
        textJson.add("{");
        textJson.add("\"table\":\"Employers\",");
        for (Employee employee : store.findBy(filter)) {
            textJson.add(String.format("\"Name\":\"%s\",", employee.getName()));
            textJson.add(String.format("\"Salary\":\"%s\",", employee.getSalary()));
        }
        textJson.add("}");
        return textJson.toString();
    }
}

