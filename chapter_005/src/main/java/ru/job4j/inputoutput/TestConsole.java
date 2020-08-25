package ru.job4j.inputoutput;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class TestConsole {
    private Connection cn;

    public void init() {
        try (InputStream in = TestConsole.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    public List add(List item) {
        try {
            PreparedStatement st = this.cn.prepareStatement
                    ("insert into test_car(name_car) values(?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,item.get(0).toString());

            st.executeUpdate();
            ResultSet generatedKey = st.getGeneratedKeys();
            System.out.println("generatedKey = " + generatedKey);
            if(generatedKey.next()) {
                System.out.println(generatedKey.getInt(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {

        TestConsole testConsole = new TestConsole();
        testConsole.init();
        List<String> item = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String srt = in.nextLine();
        item.add(srt);
        in.close();
        testConsole.add(item);
    }

}
