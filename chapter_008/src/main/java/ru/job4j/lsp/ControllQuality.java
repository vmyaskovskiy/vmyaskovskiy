package ru.job4j.lsp;

public class ControllQuality {
    private Store store;
    public ControllQuality(Store store) {
        this.store = store;
    }

    Warehouse warehouse = new Warehouse();
    Shop shop = new Shop();

    public void controllQuality() {
        for(Food food: this.store.getArrayList()) {
            if (food.getPrice() < 100) {
                warehouse.add(food);
            } else if(food.getPrice() > 100 && food.getPrice() <= 200) {
                food.setDisscount(10);
                shop.add(food);
            }
        }
    }


}
