package ru.job4j.Lsp;


import java.util.List;

public class TestMenu {
    public static void main(String[] args) {
        MenuLevel menuLevel = new MenuLevel();
        Action action0 = new ActionZero();
        Action actItem1 = new ActionOne();
        Action actItem2 = new ActionTwo();
        Action actItem3 = new ActionThree();
        Action actItem4 = new ActionFour();
        Item item0 = new Item("Menu", action0);
        Item item1 = new Item("Task1", actItem1);
        Item item1_1 = new Item("Task1_1", actItem2);
        Item item1_2 = new Item("Task1_2", actItem3);
        Item item2 = new Item("Task2", actItem4);
        menuLevel.addParent(item0);
       // item0.getItems().add(item1);
      //  item0.getItems().add(item2);
      //  item1.getItems().add(item1_1);


        menuLevel.addChild("Menu", item1);
        menuLevel.addChild("Task1", item1_1);

        menuLevel.addChild("Menu", item2);
        menuLevel.addChild("Task1_1", item1_2);

        System.out.println("tree  создадим дерево");


       // List<Item> items = menuLevel.getListNew();
      //  Item res = menuLevel.findChild("Task1");
      //  System.out.println(res.getName());
      //  System.out.println(res.getItems().get(0).getName());
      //  System.out.println(" вывод меню ");

      //  List<Item> tree = res.getItems();
      //  for(Item el: tree) {
      //      System.out.println(el.getName());
      //  }

       // List<Item> res = menuLevel.menu();
       // for(Item el: res) {
       //           System.out.println(el.getName());
       //       }

         menuLevel.traverse(item0);
         menuLevel.menuPrint();

    }
}
