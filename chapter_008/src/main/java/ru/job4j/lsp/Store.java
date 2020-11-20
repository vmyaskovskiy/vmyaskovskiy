package ru.job4j.lsp;

import java.util.ArrayList;

public class Store {
    ArrayList<Food> arrayList = new ArrayList<>();
    public void add(Food food) {
        arrayList.add(food);
    }
    public ArrayList<Food> getArrayList() {
        return this.arrayList;
    }

}
