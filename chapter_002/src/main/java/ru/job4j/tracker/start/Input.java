package ru.job4j.tracker.start;
/**
 * Interface Input решение задачи части 002 - урок Полиморфизм. Реализовать класс ConsoleInput в классе StartUI .
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    Integer ask(String question);
    String askTwo(String question);
    int ask(String question, int[] range);
}
