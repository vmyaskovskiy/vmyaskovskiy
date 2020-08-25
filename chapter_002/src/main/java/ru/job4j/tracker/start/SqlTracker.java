package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private List<Item> items = new ArrayList<>();
    private Connection cn;
    public  SqlTracker() {
        this.init();
    }
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
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

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        int idItem = 0;
        try {

            PreparedStatement st = this.cn.prepareStatement
                    ("insert into tracker(item_name, item_description) values(?,?)"
                            , Statement.RETURN_GENERATED_KEYS);

            st.setString(1,item.getName());
            st.setString(2,item.getDescription());
            st.executeUpdate();
            ResultSet generatedKey = st.getGeneratedKeys();

            if(generatedKey.next()) {
                idItem = generatedKey.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return findById(idItem);
    }

    @Override
    public boolean replace(Integer id, Item item) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Item> getAll() {
        return null;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(Integer id) {
        Item result = new Item();
        try {
            PreparedStatement st = this.cn.prepareStatement
                    ("select * from tracker where id = (?)");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("item_name"));
                result.setDescription(rs.getString("item_description"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}

