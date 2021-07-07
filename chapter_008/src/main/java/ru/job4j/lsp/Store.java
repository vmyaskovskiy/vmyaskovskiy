package ru.job4j.lsp;

import java.util.ArrayList;

public interface Store {
    boolean acccept(Food f);
    void add(Food f);
    ArrayList<Food> getArrayList();
    public void clearStore();
}
