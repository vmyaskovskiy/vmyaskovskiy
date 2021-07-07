package ru.job4j.lsp;

import java.util.ArrayList;

public class Shop implements Store{
    ArrayList<Food> arrayList = new ArrayList<>();

    @Override
    public boolean acccept(Food food) {
        boolean res = false;
        DateFormat dateFormat = new DateFormat(food.getCreateDate(), food.getExpaireDate());

        double resDate = dateFormat.procExpaireDate();
        if (resDate <= 75 && resDate >= 25) {
            res = true;
        } else if(resDate < 25 && !dateFormat.endDate()) {
            food.setDisscount(50);
            res = true;
        }
        return res;
    }
    public void add(Food food) {
            arrayList.add(food);
    }
    public ArrayList<Food> getArrayList() {
        return this.arrayList;
    }
    public void clearStore() {
        this.arrayList.clear();
    }
}
