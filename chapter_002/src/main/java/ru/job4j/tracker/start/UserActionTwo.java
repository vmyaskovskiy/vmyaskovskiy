package ru.job4j.tracker.start;

import java.sql.SQLException;

/**
 * interface UserAction определяет методы , общие для всех событий. Решение задачи - Реализовать события на внутренних классах.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public interface UserActionTwo {
    int key();
    void execute(Input input, SqlTracker trackerTwo) throws SQLException;
    String info();
}

