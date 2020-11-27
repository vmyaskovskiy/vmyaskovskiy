package ru.job4j.lsp;

public class ControllQuality {

   private Store store;
   public ControllQuality(Store store) {
       this.store = store;
   }

   public void execute(Food food) {
       store.acccept(food);
       store.add(food);
   }
}
