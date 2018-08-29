package ru.job4j.tracker.start;
/**
 * Class StartUi решение задачи части 002 - урок Внутренние классы.  Решение задачи - Реализовать события на внутренних классах..
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class StartUiNew {
    private Input input;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
    public StartUiNew(Input input) {
        this.input = input;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();
        boolean exit = false;
        while (!exit) {
            menu.show();
            int key = Integer.valueOf(input.ask("Select"));
            if (key != 6) {
            menu.select(key);
            } else {
                menu.select(key);
                exit = true;
            }
        }
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUiNew(input).init();
    }
}
