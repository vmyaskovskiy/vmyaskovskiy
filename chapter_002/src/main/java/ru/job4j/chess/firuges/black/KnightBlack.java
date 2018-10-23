package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.OccupiedWeyException;

/**
 * Class KnightBlack решение задачи части 002 - Контрольные вопросы.  Решение задачи - Каркас шахматной доски.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }
    /**
     * Метод way просчитывает правильный путь фигуры, выдает исключение если фигура движется неправильн.
     *
     * @param source  координаты ячейки откуда ходят
     * @param dest  координаты ячейки куда ходят
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
            steps = new Cell[] {dest};
        } else {
            throw new OccupiedWeyException("так нельзя ходить");
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
