package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * Class ImportDB решение задачи части 4.3. XML XSLT JDBC Оптимизация[20459#143674].
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            String line;
            while ((line = rd.readLine()) != null) {
                int indStart = 0;
                int indEmail = line.indexOf("@") - 1;
                char[] chars = line.toCharArray();
                int indEnd = chars.length;
                for (int i = indEmail; i < indEnd; i--) {
                    if (!Character.isLetter(chars[i])) {
                        indStart = i;
                        break;
                    }
                }
                String login = line.substring(0, indStart);
                String email = line.substring(indStart + 2, indEnd - 1);
                users.add(new User(login, email));
            }
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("driver-class-name"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("url"),
                cfg.getProperty("username"),
                cfg.getProperty("password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values(?,?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("C:/projects/vmyaskovskiy/chapter_006/src/main/resources/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "C:/projects/vmyaskovskiy/chapter_006/spam.txt");
        db.save(db.load());
    }
}
