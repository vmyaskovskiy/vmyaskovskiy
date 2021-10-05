package ru.job4j.lsp;

import java.util.ArrayList;

public class Shop implements Store{
    ArrayList<Food> arrayList = new ArrayList<>();
    ArrayList<Food> res = new ArrayList<>();
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
        System.out.println("shop " + food.getName() + "  " + food.getDisscount());
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
