package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportEngineBUH implements RepEngine {
    private Store store;
    public ReportEngineBUH(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : store.findBy(filter)) {
            int salaryBuh = (int) employee.getSalary();
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(salaryBuh).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
