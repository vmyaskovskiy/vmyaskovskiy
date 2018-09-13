package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Arrays;


/**
 * Class MenuTracker решение задачи части 002 - урок Внутренние классы.  Решение задачи - Реализовать события на внутренних классах..
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[100];
    private StartUi su;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker, StartUi su) {
        this.input = input;
        this.tracker = tracker;
        this.su = su;
    }
    public void fillAction() {
         this.actions[0] = new AddItem(0, "Add the new item");
         this.actions[1] = new ShowItems(1, "Show all items");
         this.actions[2] = new EditItems(2, "Edit items");
         this.actions[3] = new DeleteItem(3, "Delete item");
         this.actions[4] = new FindItemsById(4, "Find items by id");
         this.actions[5] = new FindItemsByName(5, "Find items by name");
         this.actions[6] = new Exit(6, "Exit");
    }
    public int[] range() {
        int[] range = new int[this.actions.length];
        int count = 0;
        for (UserAction action: this.actions) {
            if (action != null) {
                range[count++] = action.key();
            }
        }
        return Arrays.copyOf(range, count);
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
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
    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
          super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
           String name = input.ask("Введите имя заявки :");
           String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }
    }
    /**
     * Class ShowItems  статический внутренний класс. реализовывает отображение всех найденных заявок.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private  class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
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
    }
    /**
     * Class EditItems  внутренний класс. реализовывает редактирование заявок.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private  class  EditItems extends BaseAction {
        public EditItems(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() != 0) {
                String id = input.ask("Введите Id заявки :");
                if (tracker.findById(id) != null) {
                    String name = input.ask("Введите имя заявки :");
                    String desc = input.ask("Введите описание заявки :");
                    Item itemRes = new Item(name, desc);
                    tracker.replace(id, itemRes);
                } else {
                    System.out.println("---введен некоректный Id----");
                }
            } else {
                System.out.println("---заявки не найдены----");
            }
        }
    }
    /**
     * Class DeleteItem внутренний класс. реализовывает отображение удаление заявок.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID :");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка удалена успешно --------------");
            } else {
                System.out.println("------------ Заявка не найдена --------------");
            }
        }
    }
    /**
     * Class FindItemsById внутренний класс. реализовывает поиск заявок по ID.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class FindItemsById extends BaseAction {
        public FindItemsById(int key, String name) {
            super(key, name);
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
    }
    /**
     * Class FindItemsByName внутренний класс. реализовывает поиск заявок по Имени.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
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
    }
    /**
     * Class Exit внутренний класс. реализовывает выход из программы.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private class Exit extends BaseAction {
        public Exit(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
            MenuTracker.this.su.setExit(true);
        }
    }
}
