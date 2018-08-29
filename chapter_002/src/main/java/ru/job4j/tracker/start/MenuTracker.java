package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
/**
 * Class EditItems внешний внутренний класс. реализовывает редактирование заявок.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
class  EditItems implements UserAction {
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker) {
        if (tracker.getPosition() != 0) {
            String id = input.ask("Введите Id заявки :");
            Item itemR = tracker.findById(id);
            if (itemR != null && itemR.getId().equals(id)) {
                String name = input.ask("Введите имя заявки :");
                String desc = input.ask("Введите описание заявки :");
                Item itemRes = new Item(name, desc);
                tracker.replace(id, itemRes);
            } else {
                System.out.println("---заявка не найдена----");
            }
        } else {
            System.out.println("---заявки не найдены----");
        }
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Edit items");
    }
}
/**
 * Class MenuTracker решение задачи части 002 - урок Внутренние классы.  Решение задачи - Реализовать события на внутренних классах..
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * хранит ссылку на объект .
     */
    private Input input;
    /**
     * хранит ссылку на объект .
     */
    private Tracker tracker;
    private UserAction[] actions = new UserAction[10];
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод заполняет массив.
     */
    public void fillAction() {
         this.actions[0] = new AddItem();
         this.actions[1] = new MenuTracker.ShowItems();
         this.actions[2] = new EditItems();
         this.actions[3] = new DeleteItem();
         this.actions[4] = new FindItemsById();
         this.actions[5] = new FindItemsByName();
         this.actions[6] = new Exit();
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     * Class AddItem  внутренний класс. реализовывает добавление заявок.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }
    /**
     * Class ShowItems  статический внутренний класс. реализовывает отображение всех найденных заявок.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() != 0) {
                System.out.println("------------ Найденные заявки --------------");
                for (Item item : tracker.getAll()) {
                    System.out.println(
                            String.format("%s. %s. %s. %s", item.getId(), item.getName(), item.getDescription(), item.getCreate())
                    );
                }
            } else {
                System.out.println("---заявки не найдены----");
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Show all itms");
        }
    }
    /**
     * Class DeleteItem внутренний класс. реализовывает отображение удаление заявок.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID :");
            Item item = tracker.findById(id);
            if (item != null && item.getId().equals(id)) {
                tracker.delete(id);
                System.out.println("------------ Заявка удалена успешно --------------");
            } else {
                System.out.println("------------ Заявка не найдена --------------");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }
    /**
     * Class FindItemsById внутренний класс. реализовывает поиск заявок по ID.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class FindItemsById implements UserAction {
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки --------------");
            String id = input.ask("Введите ID :");
            Item item = tracker.findById(id);
            if (item != null && item.getId().equals(id)) {
                System.out.println("------------ Найденная заявка --------------");
                System.out.println(item);
            } else {
                System.out.println("------------ Заявка не найдена --------------");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find items by id");
        }
    }
    /**
     * Class FindItemsByName внутренний класс. реализовывает поиск заявок по Имени.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class FindItemsByName implements UserAction {
        public int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки --------------");
            if (tracker.getPosition() != 0) {
                String name = input.ask("Введите имя заявки :");
                System.out.println("------------ Найденные заявки --------------");
                for (Item item: tracker.findByName(name)) {
                    System.out.println(item);
                }
            } else {
                System.out.println("------------ Заявки не найдены --------------");
            }

        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }
    /**
     * Class Exit внутренний класс. реализовывает выход из программы.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class Exit implements UserAction {
        public int key() {
            return 6;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Exit");
        }
    }
}
