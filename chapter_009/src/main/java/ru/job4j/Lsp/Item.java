package ru.job4j.Lsp;

import java.util.ArrayList;
import java.util.List;

public class Item {
    //элемент меню
    //Item должен быть классом. Внутри него должны быть поля:
    //String name, имя действия. Будем считать что оно уникально (для поиска)
    //Action action, действия "при выборе" данного пункта
    //List<Item> items, дочерние элементы


    public String name;
    public Action action;
    public List<Item> items = new ArrayList<>();

    public Item (String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    public Action action() {
        return this.action();
    }
}
