package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {

    Item add(Item item) throws SQLException;
    boolean replace(Integer id, Item item) throws SQLException;
    boolean delete(Integer id) throws SQLException;
    List<Item> getAll() throws SQLException;
    List<Item> findByName(String key) throws SQLException;
    Item findById(Integer id) throws SQLException;
}

