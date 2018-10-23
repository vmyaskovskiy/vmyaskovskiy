package ru.job4j.chess.firuges;
/**
 * interface Figure решение задачи части 002 - абстрактный класс - описывает абстрактное поведение шахматной доски.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }
    Figure copy(Cell dest);

}
