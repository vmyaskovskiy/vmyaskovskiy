package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlTracker implements Store,  AutoCloseable {
    private Connection cn;


    public  SqlTracker(Connection connection) {
        this.cn = connection;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        int idItem = 0;
        try (PreparedStatement st = this.cn.prepareStatement("insert into tracker(item_name, item_description) values(?,?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.executeUpdate();
            try (ResultSet generatedKey = st.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    idItem = generatedKey.getInt(1);
                }
            }
            return findById(idItem);
        }
    }

    @Override
    public boolean replace(Integer id, Item item) throws SQLException {
        boolean res = false;
        try (PreparedStatement st = this.cn.prepareStatement("update  tracker set item_name = (?) , item_description = (?) where  id = (?)")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setInt(3, id);
            st.executeUpdate();
            res = true;
        }
        return res;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        boolean res = false;
        try (PreparedStatement st = this.cn.prepareStatement("delete from tracker where id = (?)")) {
                  st.setInt(1, id);
                  st.executeUpdate();
                  res = true;
                }
        return res;
    }

    @Override
    public List<Item> getAll() throws SQLException {
        Item item = new Item();
        List<Item> items = new ArrayList<>();
        try (PreparedStatement st = this.cn.prepareStatement("select * from tracker")) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("item_name"));
                    item.setDescription(rs.getString("item_description"));
                    items.add(findById(item.getId()));
                }
                return items;
            }
        }
    }

    @Override
    public List<Item> findByName(String name) throws SQLException {
        Item result = new Item();
        List<Item> items = new ArrayList<>();
        try (PreparedStatement st = this.cn.prepareStatement("select * from tracker where item_name = (?)")) {
            st.setString(1, name);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setName(rs.getString("item_name"));
                    result.setDescription(rs.getString("item_description"));
                    items.add(findById(result.getId()));
                }
            }
        }
        return items;
    }

    @Override
    public Item findById(Integer id) throws SQLException {
        Item result = new Item();
        try (PreparedStatement st = this.cn.prepareStatement("select * from tracker where id = (?)")) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setName(rs.getString("item_name"));
                    result.setDescription(rs.getString("item_description"));
                }
            }
        }
        return result;
    }

}

