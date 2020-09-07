package ru.job4j.tracker;
import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.ConnectionRollback;
import ru.job4j.tracker.start.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("nameTest2", "desc"));
            assertThat(tracker.findByName("nameTest2").size(), is(1));
        }
    }
    @Test
    public void replaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.replace(3, new Item("replaceName", "desc"));
            assertThat(tracker.findById(3).getName(), is("replaceName"));
        }
    }
    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.delete(17);
            assertThat(tracker.findByName("test edit").size(), is(0));
        }
    }
    @Test
    public void getAllItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.getAll().size(), is(20));
        }
    }

    @Test
    public void findByNameItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.findByName("test edit").size(), is(1));
            assertThat(tracker.findByName("test edit").get(0).getName(), is("test edit"));
        }
    }
    @Test
    public void findByIdItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.findById(17).getName(), is("test edit"));
        }
    }
}
