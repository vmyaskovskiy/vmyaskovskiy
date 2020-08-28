package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
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
        boolean res = false;
        try {
            PreparedStatement st = this.cn.prepareStatement
                    ("update  tracker set item_name = (?) , item_description = (?) where  id = (?)");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setInt(3, id);
            st.executeUpdate();
            res = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public boolean delete(Integer id) {
        boolean res = false;
        try {
            try {
                PreparedStatement st = this.cn.prepareStatement
                        ("delete from tracker where id = (?)");
                st.setInt(1, id);
                try {
                    st.executeUpdate();
                    res = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    st.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public List<Item> getAll() {
        Item item = new Item();
        List<Item> items = new ArrayList<>();
        try {
            try {
                PreparedStatement st = this.cn.prepareStatement
                        ("select * from tracker");
                try {
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        item.setId(rs.getInt("id"));
                        item.setName(rs.getString("item_name"));
                        item.setDescription(rs.getString("item_description"));
                        items.add(findById(item.getId()));
                    }
                    rs.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                st.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    @Override
    public List<Item> findByName(String name) {
        Item result = new Item();
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement st = this.cn.prepareStatement
                    ("select * from tracker where item_name = (?)");
            st.setString(1, name );
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("item_name"));
                result.setDescription(rs.getString("item_description"));
                items.add(findById(result.getId()));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return items;
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

