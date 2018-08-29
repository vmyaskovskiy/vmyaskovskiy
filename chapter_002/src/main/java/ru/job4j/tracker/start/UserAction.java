package ru.job4j.tracker.start;
/**
 * interface UserAction определяет методы , общие для всех событий. Решение задачи - Реализовать события на внутренних классах.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
