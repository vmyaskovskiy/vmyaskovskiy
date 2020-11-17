package ru.job4j.srp;
import java.util.StringJoiner;
import java.util.function.Predicate;
public class ReportEngineXML implements RepEngine {
    private Store store;
    public ReportEngineXML(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {

        StringJoiner textXml = new StringJoiner(System.lineSeparator());

        textXml.add("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        textXml.add("<table>Employers</table>");
        textXml.add("<Employer>");
        for (Employee employee : store.findBy(filter)) {

            textXml.add(String.format("<Name>%s</Name>", employee.getName()));
            textXml.add(String.format("<Salary>%s</Salary>", employee.getSalary()));

        }

        textXml.add("</Employer>");
        return textXml.toString();
    }
}
