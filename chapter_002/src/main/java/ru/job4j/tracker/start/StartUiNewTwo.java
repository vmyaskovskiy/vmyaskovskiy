package ru.job4j.tracker.start;


import java.util.function.Consumer;

public class StartUiNewTwo {
    private Input input;
    private SqlTracker trackerTwo;
    private boolean exit = false;
    private final  Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
public StartUiNewTwo(Input input, SqlTracker trackerTwo, Consumer<String> output) {
        this.input = input;
        this.trackerTwo = trackerTwo;
        this.output = output;
        }

        /**
 * Основой цикл программы.
 */
public void init() {

        MenuTrackerTwo menu = new MenuTrackerTwo(this.input, this.trackerTwo, this, this.output);
        //trackerTwo.init();
        menu.fillAction();
        int[] range = menu.range();
        while (!exit) {
        menu.show();
        int key = input.ask("Select", range);
        menu.select(key);
        }
        }
public static void main(String[] args) {
        Store tracker = new SqlTracker();
        tracker.init();
        new StartUiNewTwo(new ValidateInput(new ConsoleInput()), new SqlTracker(), System.out::println).init();
        }

public void setExit(boolean exit) {
        this.exit = exit;
        }
        }

