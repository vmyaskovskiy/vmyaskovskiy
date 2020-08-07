package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.List;

public interface Store extends AutoCloseable {
    void init();
    Item add(Item item);
    boolean replace(Integer id, Item item);
    boolean delete(Integer id);
    List<Item> getAll();
    List<Item> findByName(String key);
    Item findById(Integer id);
}

