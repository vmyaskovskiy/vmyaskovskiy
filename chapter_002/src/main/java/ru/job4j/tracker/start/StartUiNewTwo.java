package ru.job4j.tracker.start;


import java.util.function.Consumer;

public class StartUiNewTwo {
    private Input input;
    private TrackerTwo trackerTwo;
    private boolean exit = false;
    private final  Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
public StartUiNewTwo(Input input, TrackerTwo trackerTwo, Consumer<String> output) {
        this.input = input;
        this.trackerTwo = trackerTwo;
        this.output = output;
        }

        /**
 * Основой цикл программы.
 */
public void init() {
        MenuTrackerTwo menu = new MenuTrackerTwo(this.input, this.trackerTwo, this, this.output);
        menu.fillAction();
        int[] range = menu.range();
        while (!exit) {
        menu.show();
        int key = input.ask("Select", range);
        menu.select(key);
        }
        }
public static void main(String[] args) {
        new StartUiNewTwo(new ValidateInput(new ConsoleInput()), new TrackerTwo(), System.out::println).init();
        }

public void setExit(boolean exit) {
        this.exit = exit;
        }
        }

