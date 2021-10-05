package ru.job4j.Lsp;

import java.util.*;

public class MenuLevel implements Menu {
    List<Item> items = new ArrayList<>();
   // Menu сделать интерфейсом. Минимальные функционал этого класса должен заключаться в методах:
   //void add(String parentName, Item child);
   // добавляет потомка к предку. Служит чтоб сконструировать меню
    @Override
    public void add(String parentName, Item child) {
        this.items.get(0);
       Item parent = this.get(parentName);
        for (Item child1 : parent.getItems()) {
            child1.getItems().add(child);
        }
    }

    public void addParent(Item parent) {
        this.items.add(parent);
    }

    //Item get(String name); // получает пункт по имени. Уже из него можно вытащить действие, которое можно будет вызвать

    @Override
    public Item get(String name) {
        Item res = null;
        for(Item item: this.items) {
            if(item.getName().equals(name)) {
                res = item;
            }
        }
        return res;
    }

    public void addChild(String parent, Item item) {
       Item parentNew = findChild(parent);
        System.out.println(parentNew.getName());
       parentNew.getItems().add(item);
    }

        public Item findChild (String child){
            Item res = null;
                Item parent = this.items.get(0);
                if (child.equals(parent.getName())) {
                    res = parent;
                } else {
                    Queue<Item> data1 = new LinkedList<>();
                    data1.add(parent);
                    while (!data1.isEmpty()) {
                        List<Item> str = data1.poll().getItems();
                        for (Item el : str) {
                            if (el.getItems().isEmpty()) {
                                if (el.getName().equals(child)) {
                                    res = el;
                                }
                            } else if (el.getName().equals(child)) {
                                res = el;
                            } else {
                                data1.add(el);
                            }
                        }
                    }
                }

                return res;

        }


    Set<String> menuLevel = new HashSet<>();


    public void traverse(Item child){
        for(Item each : child.getItems()){
            menuLevel.add(" " + each.getName());
            traverse(each);
        }
    }
    public void menuPrint() {
        System.out.println(this.items.get(0).getName());
        for(String str: menuLevel) {
            System.out.println(str);
        }
    }
}
