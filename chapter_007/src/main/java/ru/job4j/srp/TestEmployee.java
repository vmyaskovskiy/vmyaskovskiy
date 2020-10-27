package ru.job4j.srp;

import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class TestEmployee {

    // метод Calendar преобразовывает util.data в calendar
    private Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    // метод преобразовывает дату заданную в формате string в формат util.data
    // а затем возвращает calendar
    public Calendar cal (String date) throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        //Date dateHir =  sdf.parse(date);
        //Calendar calendar = dateToCalendar(sdf.parse(date));
        return dateToCalendar(new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(date));
    }

    static Connection connection() {
        try (InputStream in = TestEmployee.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return  DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    public static void main(String[] args) throws ParseException , SQLException{

        Connection cn = connection();
        TestEmployee testEmployee = new TestEmployee();
        Employee employee = new Employee("Sasha",
                                          testEmployee.cal("22-01-2017 10:20:56"),
                                          testEmployee.cal("22-01-2022 10:20:56"),
                                         14000);


        try (PreparedStatement st = cn.prepareStatement("insert into emploers(name, hired, fired, salary) values (?, ?, ?, ?)")) {
            st.setString(1, employee.getName());
            // преобразовываем java.util.Date в java.sql.Date для записи в базу данных
            st.setDate(2, new java.sql.Date(employee.getHired().getTime().getTime()));
            st.setDate(3, new java.sql.Date(employee.getFired().getTime().getTime()));
            st.setDouble(4, employee.getSalary());
            st.executeUpdate();
        }
    }
}
