package ru.job4j.inputoutput;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestReadSpam {


    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader("C:/projects/vmyaskovskiy/chapter_005/spam.txt"))) {

            String line;
            while ((line = rd.readLine()) != null) {
                String[] word = line.split(";");
                users.add(new User(word[0], word[1]));
            }


        }
        return users;
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws IOException {
        TestReadSpam testReadSpam = new TestReadSpam();
        System.out.println(testReadSpam.load());
    }


}
