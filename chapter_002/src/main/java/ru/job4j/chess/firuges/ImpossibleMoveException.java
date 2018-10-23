package ru.job4j.chess.firuges;
/**
 * Class ImpossibleMoveException решение задачи части 002 - Исключение , если фигура движется некорректно.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ImpossibleMoveException extends RuntimeException {
    private final String msg;
    public ImpossibleMoveException(String msg) {
        super(msg);
        this.msg = msg;
    };
}
