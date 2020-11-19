package ru.job4j.srp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestReport {

    private Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    public Calendar cal (String date) throws ParseException {
        return dateToCalendar(new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(date));
    }

    public static void main(String[] args) throws ParseException {
        TestReport testReport = new TestReport();
        Employee employee = new Employee("Sasha",
                testReport.cal("22-01-2017 10:20:56"),
                testReport.cal("22-01-2022 10:20:56"),
                14000);
        employee.setSalary(2355.66);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        System.out.println(employeeList.get(0).getName() + " " + employeeList.get(0).getSalary());

    }
}
