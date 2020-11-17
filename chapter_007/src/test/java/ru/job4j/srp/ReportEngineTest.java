package ru.job4j.srp;


import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;
import java.util.StringJoiner;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 300);
        Employee worker1 = new Employee("Slava", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportEngine engine = new ReportEngine(store);
        System.out.println(engine.generate(em -> true));
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName() == "Slava"), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 300);
        Employee worker1 = new Employee("Slava", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportEngineHR engine = new ReportEngineHR(store);
        System.out.println(engine.generate(em -> true));
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName() == "Slava"), is(expect.toString()));
    }

    @Test
    public void whenBUHGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 300);
        Employee worker1 = new Employee("Slava", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportEngineBUH engine = new ReportEngineBUH(store);
        System.out.println(engine.generate(em -> true));
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append((int) (worker1.getSalary())).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName() == "Slava"), is(expect.toString()));
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 300);
        Employee worker1 = new Employee("Slava", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportEngineHTML engine = new ReportEngineHTML(store);
        System.out.println(engine.generate(em -> true));
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

            texthtml.add("<tr>");
            texthtml.add(String.format("<td>%s</td>", worker1.getName()));
            texthtml.add(String.format("<td>%s</td>", worker1.getSalary()));
            texthtml.add("</tr>");

        assertThat(engine.generate(em -> em.getName() == "Slava"), is(texthtml.toString()));
    }

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 300);
        Employee worker1 = new Employee("Slava", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportEngineXML engine = new ReportEngineXML(store);
        System.out.println(engine.generate(em -> true));
        StringJoiner textXml = new StringJoiner(System.lineSeparator());
        textXml.add("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        textXml.add("<table>Employers</table>");
        textXml.add("<Employer>");
            textXml.add(String.format("<Name>%s</Name>", worker1.getName()));
            textXml.add(String.format("<Salary>%s</Salary>", worker1.getSalary()));
        textXml.add("</Employer>");
        assertThat(engine.generate(em -> em.getName() == "Slava"), is(textXml.toString()));
    }

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 300);
        Employee worker1 = new Employee("Slava", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportEngineJSON engine = new ReportEngineJSON(store);
        System.out.println(engine.generate(em -> true));
        StringJoiner textJson = new StringJoiner(System.lineSeparator());
        textJson.add("{");
        textJson.add("\"table\":\"Employers\",");
            textJson.add(String.format("\"Name\":\"%s\",", worker1.getName()));
            textJson.add(String.format("\"Salary\":\"%s\",", worker1.getSalary()));
        textJson.add("}");
        assertThat(engine.generate(em -> em.getName() == "Slava"), is(textJson.toString()));
    }
}

