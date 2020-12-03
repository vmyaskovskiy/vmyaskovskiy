package ru.job4j.lsp;

import java.util.ArrayList;

public class Trash implements Store {

    ArrayList<Food> arrayList = new ArrayList<>();

    @Override
    public boolean acccept(Food food) {
        DateFormat dateFormat = new DateFormat(food.getCreateDate(), food.getExpaireDate());
        return (dateFormat.endDate());
    }

    public void add(Food food) {
            arrayList.add(food);
    }
    public ArrayList<Food> getArrayList() {
        return this.arrayList;
    }
}
