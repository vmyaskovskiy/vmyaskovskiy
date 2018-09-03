package ru.job4j.tracker.start;
/**
 * Class Input решение задачи части 002 - урок Полиморфизм. Реализовать класс ConsoleInput в классе StartUI .
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
