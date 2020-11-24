package ru.job4j.lsp;

import java.util.ArrayList;

public class Warehouse implements Store{


    ArrayList<Food> arrayList = new ArrayList<>();

    @Override
    public boolean acccept(Food food) {
        return food.getPrice() < 100;
    }

    public void add(Food food) {
        if(acccept(food)){
        arrayList.add(food);
        }
    }
    public ArrayList<Food> getArrayList() {
        return this.arrayList;
    }




}
