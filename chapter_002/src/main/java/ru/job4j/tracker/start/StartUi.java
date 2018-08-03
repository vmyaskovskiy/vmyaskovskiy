package ru.job4j.tracker.start;
import ru.job4j.tracker.models.*;
/**
 * Class StartUi решение задачи части 002 - урок Полиморфизм. Реализовать класс ConsoleInput в классе StartUI .
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class StartUi {
        /**
         * Константы меню.
         */
        private static final String ADD = "0";
        private static final String SHOWALL = "1";
        private static final String EDIT = "2";
        private static final String DELETE = "3";
        private static final String FINDBYID = "4";
        private static final String FINDBYNAME = "5";
        /**
         * Константа для выхода из цикла.
         */
        private static final String EXIT = "6";
        /**
         * Получение данных от пользователя.
         */
        private Input input;
        /**
         * Хранилище заявок.
         */
        private  Tracker tracker;
        /**
         * Конструтор инициализирующий поля.
         * @param input ввод данных.
         * @param tracker хранилище заявок.
         */
        public  StartUi(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }
        /**
         * Основой цикл программы.
         */
        public void init() {
            boolean exit = false;
            while (!exit) {
                this.showMenu();
                String answer = this.input.ask("Введите пункт меню : ");
                if (ADD.equals(answer)) {
                    this.createItem();
                } else if (SHOWALL.equals(answer)) {
                    this.showAllItem();
                } else if (EDIT.equals(answer)) {
                    this.editItem();
                } else if (DELETE.equals(answer)) {
                    this.deleteItem();
                } else if (FINDBYID.equals(answer)) {
                    this.findItemById();
                } else if (FINDBYNAME.equals(answer)) {
                    this.findItemByName();
                } else if (EXIT.equals(answer)) {
                    exit = true;
                }
            }
        }
        /**
         * Метод реализует добавленяи новый заявки в хранилище.
         */
        private void createItem() {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            this.tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
        /**
        * Метод реализует редактирование заявок.
        */
        private void editItem() {

            if (tracker.getPosition() != 0) {
            String id = this.input.ask("Введите ID");
             Item itemR = tracker.findById(id);
                if (itemR != null && itemR.getId().equals(id)) {
                    String name = this.input.ask("Введите имя заявки :");
                    String desc = this.input.ask("Введите описание заявки :");
                    Item itemRes = new Item(name, desc);
                    this.tracker.replace(id, itemRes);
                    System.out.println(itemRes);

            } else {
                    System.out.println("---заявка не найдена----");
                }
            } else {
                System.out.println("---заявки не найдены----");
            }
        }
        /**
        * Метод реализует поиск заявки по имени.
         */
        private void findItemByName() {
            System.out.println("------поиск заявки по имени-----------");
            String name = this.input.ask("Введите имя заявки :");
            if (this.tracker.getPosition() != 0) {
                System.out.println("----------Найденные заявки------------");
                for (Item item: this.tracker.findByName(name)) {
                    System.out.println(item);
                }
            } else {
                System.out.println("-- ничего не найдено---");
            }
        }
        /**
        * Метод реализует отображение всех заявок.
        */
        private void showAllItem() {
            System.out.println("----------Показать все заявки---------");
            if (tracker.getPosition() != 0) {
                System.out.println("----------Найденные заявки------------");
                for (Item item: this.tracker.getAll()) {
                    System.out.println("Id -- " + item.getId() + " " + ";  Имя -- " + item.getName() + " " + ";  Описание -- " + item.getDescription() + " " + ";  Data -- " + item.getCreate());
                }
            } else {
                System.out.println("-- ничего не найдено---");
            }
        }
        /**
        * Метод реализует удаление  заявки.
        */
        private void deleteItem() {
            System.out.println("--------Удалить заявку------------");
           if (tracker.getPosition() != 0) {
               String id = this.input.ask("Введите ID");
               if (this.tracker.delete(id)) {
                   System.out.println("-- заявка удалена---");
               } else {
                   System.out.println("----заявка не найдена---");
               }
           }  else  {
               System.out.println("-- ничего не найдено---");
           }
        }
          /**
          * Метод реализует поиск заявки по ID.
          */
          private void findItemById() {
             System.out.println("---------Найти заявку по ID-------------");
             if (tracker.getPosition() != 0) {
                 String id = this.input.ask("Введите ID");
                 Item itemRes = this.tracker.findById(id);
                 if (itemRes != null) {
                     System.out.println(" Найдена заявка-- " + " " + itemRes);
                 } else  {
                     System.out.println("-- заявка не найдена---");
                 }
             } else  {
                 System.out.println("-- ничего не найдено---");
             }
         }
     /**
     * метод отображающий меню на экране
     */
        private void showMenu() {
            System.out.println("Меню.");
            System.out.println("0. Add new Item");
            System.out.println("1. Show all Item");
            System.out.println("2. Edit Item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");
            System.out.println("Select:");
        }
        /**
         * Запускт программы.
         * @param args
         */
        public static void main(String[] args) {
            new StartUi(new ConsoleInput(), new Tracker()).init();
        }
    }






