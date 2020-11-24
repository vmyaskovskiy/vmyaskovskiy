package ru.job4j.lsp;

public class ControllQuality {

    Warehouse warehouse = new Warehouse();
    Shop shop = new Shop();

    public void controllQuality(Food food) {
      warehouse.add(food);
      shop.add(food);
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public Shop getShop() {
        return this.shop;
    }


}
