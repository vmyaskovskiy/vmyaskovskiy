package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

   private List<Store> stores;
   private ArrayList<Food> storeFood;

   public ControllQuality(List<Store> stores, ArrayList<Food> storeFood) {
       this.stores = stores;
       this.storeFood = storeFood;
   }

   public void execute() {
       for(Food food: storeFood) {
           for(Store store1: stores) {
               if(store1.acccept(food)) {
               store1.add(food);
               }
           }
       }
    }
}
