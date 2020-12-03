package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Date;

public class Warehouse implements Store{


    ArrayList<Food> arrayList = new ArrayList<>();

    @Override
    public boolean acccept(Food food) {
        DateFormat dateFormat = new DateFormat(food.getCreateDate(), food.getExpaireDate());

        double res = dateFormat.procExpaireDate();

        return (res < 100 && res > 75);
    }

    public void add(Food food) {

        arrayList.add(food);

    }
    public ArrayList<Food> getArrayList() {
        return this.arrayList;
    }




}
