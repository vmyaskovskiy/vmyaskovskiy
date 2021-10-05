package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Warehouse implements Store{


    ArrayList<Food> arrayList = new ArrayList<>();
   // ArrayList<Food> res = new ArrayList<>();
    @Override
    public boolean acccept(Food food) {
        DateFormat dateFormat = new DateFormat(food.getCreateDate(), food.getExpaireDate());

        double res = dateFormat.procExpaireDate();

        return (res < 100 && res > 75);
    }

    public void add(Food food) {
        arrayList.add(food);
        System.out.println("warehouse " + food.getName() + "  " + food.getDisscount() );
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
