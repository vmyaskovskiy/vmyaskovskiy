package ru.job4j.lsp;

import java.util.ArrayList;

public class Trash implements Store {

    ArrayList<Food> arrayList = new ArrayList<>();
    ArrayList<Food> res = new ArrayList<>();
    @Override
    public boolean acccept(Food food) {
        DateFormat dateFormat = new DateFormat(food.getCreateDate(), food.getExpaireDate());
        return (dateFormat.endDate());
    }

    public void add(Food food) {
            arrayList.add(food);
        System.out.println("trash " + food.getName() + "  " + food.getDisscount() );
    }
    public ArrayList<Food> getArrayList() {
        ArrayList<Food> res = new ArrayList<>(this.arrayList);
        this.arrayList.clear();
        return res;

    }

    //public void clear() {
    //    this.arrayList.clear();
    //}
}
