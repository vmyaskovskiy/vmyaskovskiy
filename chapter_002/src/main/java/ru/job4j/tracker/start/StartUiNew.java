package ru.job4j.tracker.start;
/**
 * Class StartUi решение задачи части 002 - урок Внутренние классы.  Решение задачи - Реализовать события на внутренних классах..
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class StartUiNew {
    private Input input;
    private Tracker tracker;
    private boolean exit = false;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
    public StartUiNew(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker, this);
        menu.fillAction();
        int[] range = menu.range();
        while (!exit) {
            menu.show();
            int key = input.ask("Select", range);
            menu.select(key);
        }
    }
    public static void main(String[] args) {
        new StartUiNew(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
