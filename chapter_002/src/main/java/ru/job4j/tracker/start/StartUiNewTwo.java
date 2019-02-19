package ru.job4j.tracker.start;


public class StartUiNewTwo {
    private Input input;
    private TrackerTwo trackerTwo;
    private boolean exit = false;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
public StartUiNewTwo(Input input, TrackerTwo trackerTwo) {
        this.input = input;
        this.trackerTwo = trackerTwo;
        }
/**
 * Основой цикл программы.
 */
public void init() {
        MenuTrackerTwo menu = new MenuTrackerTwo(this.input, this.trackerTwo, this);
        menu.fillAction();
        int[] range = menu.range();
        while (!exit) {
        menu.show();
        int key = input.ask("Select", range);
        menu.select(key);
        }
        }
public static void main(String[] args) {
        new StartUiNewTwo(new ValidateInput(new ConsoleInput()), new TrackerTwo()).init();
        }

public void setExit(boolean exit) {
        this.exit = exit;
        }
        }

