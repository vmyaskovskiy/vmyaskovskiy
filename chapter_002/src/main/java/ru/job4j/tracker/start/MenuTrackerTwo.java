package ru.job4j.tracker.start;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.job4j.tracker.models.Item;
/**
 * Class MenuTracker решение задачи части 002 - урок Внутренние классы.  Решение задачи - Реализовать события на внутренних классах..
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class MenuTrackerTwo {
    private Input input;
    private TrackerTwo trackerTwo;
   // private UserActionTwo[] actionsTwo = new UserActionTwo[100];
    private List<UserActionTwo> actionsTwoList = new ArrayList<>();
    private StartUiNewTwo su;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param trackerTwo хранилище заявок.
     */
    public MenuTrackerTwo(Input input, TrackerTwo trackerTwo, StartUiNewTwo su) {
        this.input = input;
        this.trackerTwo = trackerTwo;
        this.su = su;
    }

    public void fillAction() {
        this.actionsTwoList.add(new MenuTrackerTwo.AddItem(0, "Add the new item"));
        this.actionsTwoList.add(new MenuTrackerTwo.ShowItems(1, "Show all items"));
        this.actionsTwoList.add(new MenuTrackerTwo.EditItems(2, "Edit items"));
        this.actionsTwoList.add(new MenuTrackerTwo.DeleteItem(3, "Delete item"));
        this.actionsTwoList.add(new MenuTrackerTwo.FindItemsById(4, "Find items by id"));
        this.actionsTwoList.add(new MenuTrackerTwo.FindItemsByName(5, "Find items by name"));
        this.actionsTwoList.add(new MenuTrackerTwo.Exit(6, "Exit"));
    }

    public List<UserActionTwo> getActionsTwoList() {
        return this.actionsTwoList;
    }

    public int[] range() {
        int[] range = new int[MenuTrackerTwo.this.getActionsTwoList().size()];
        int count = 0;
        for (UserActionTwo action: this.actionsTwoList) {
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
        this.actionsTwoList.get(key).execute(this.input, this.trackerTwo);
    }
    public void show() {
        for (UserActionTwo action : this.actionsTwoList) {
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
    private class AddItem extends BaseActionTwo {
        public AddItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, TrackerTwo trackerTwo) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            trackerTwo.add(new Item(name, desc));
        }
    }
    /**
     * Class ShowItems  статический внутренний класс. реализовывает отображение всех найденных заявок.
     * @author vmyaskovskiy
     * @version $Id$
     * @since 0.1
     */
    private  class ShowItems extends BaseActionTwo {
        public ShowItems(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, TrackerTwo trackerTwo) {
            if (trackerTwo.getAll().size() != 0) {
                System.out.println("------------ Найденные заявки --------------");
                for (Item item : trackerTwo.getAll()) {
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
    private  class  EditItems extends BaseActionTwo {
        public EditItems(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, TrackerTwo trackerTwo) {
            if (trackerTwo.getAll().size() != 0) {
                String id = input.ask("Введите Id заявки :");
                if (trackerTwo.findById(id) != null) {
                    String name = input.ask("Введите имя заявки :");
                    String desc = input.ask("Введите описание заявки :");
                    Item itemRes = new Item(name, desc);
                    trackerTwo.replace(id, itemRes);
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
    private class DeleteItem extends BaseActionTwo {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, TrackerTwo tracker) {
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
    private class FindItemsById extends BaseActionTwo {
        public FindItemsById(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, TrackerTwo tracker) {
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
    private class FindItemsByName extends BaseActionTwo {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, TrackerTwo tracker) {
            System.out.println("------------ Поиск заявки --------------");
            if (trackerTwo.getAll().size() != 0) {
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
    private class Exit extends BaseActionTwo {
        public Exit(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, TrackerTwo tracker) {
            System.out.println("------------ Выход из программы --------------");
            MenuTrackerTwo.this.su.setExit(true);
        }
    }
}
