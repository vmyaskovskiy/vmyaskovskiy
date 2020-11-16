package ru.job4j.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class ReportEngineHTML implements RepEngine{
    private Store store;
    public ReportEngineHTML(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {

        StringJoiner texthtml = new StringJoiner(System.lineSeparator());

        texthtml.add("<!DOCTYPE html>");
        texthtml.add("<html>");
        texthtml.add("<head>");
        texthtml.add("<meta charset=\"UTF-8\">");
        texthtml.add("<title>Employers</title>");
        texthtml.add("</head>");
        texthtml.add("<body>");

        texthtml.add("<table>");
        texthtml.add("<tr>");
        texthtml.add("<th>Name</th>");
        texthtml.add("<th>Salary</th>");
        texthtml.add("</tr>");


        for (Employee employee : store.findBy(filter)) {
            texthtml.add("<tr>");
            texthtml.add(String.format("<td>%s</td>", employee.getName()));
            texthtml.add(String.format("<td>%s</td>", employee.getSalary()));
            texthtml.add("</tr>");
        }
        return texthtml.toString();
    }
}
