package ru.job4j.chess.firuges;
/**
 * Class OccupiedWeyException решение задачи части 002 - Исключение если путь занят.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class OccupiedWeyException extends RuntimeException {
    public OccupiedWeyException(String msg) {
        super(msg);
    }
}
