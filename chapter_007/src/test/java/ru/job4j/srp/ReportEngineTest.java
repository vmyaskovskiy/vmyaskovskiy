package ru.job4j.srp;


import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

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
        ReportEngine engine = new ReportEngine(store);
        System.out.println(engine.generateHR(em -> true));
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());


        assertThat(engine.generateHR(em -> em.getName() == "Slava"), is(expect.toString()));
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
        ReportEngine engine = new ReportEngine(store);
        System.out.println(engine.generateBUH(em -> true));
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append((int) (worker1.getSalary())).append(";")
                .append(System.lineSeparator());


        assertThat(engine.generateBUH(em -> em.getName() == "Slava"), is(expect.toString()));
    }

}

