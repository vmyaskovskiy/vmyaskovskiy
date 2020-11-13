package ru.job4j.srp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
public class ReportEngine implements RepEngine{
    private Store store;
    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> list = store.findBy(filter);
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                Integer s1 = (int) o1.getSalary();
                Integer s2 = (int) o2.getSalary();
                return s1.compareTo(s2);

            }
        });
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : list) {
                     text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}