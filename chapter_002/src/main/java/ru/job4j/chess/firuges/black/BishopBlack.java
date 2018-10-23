package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.OccupiedWeyException;

/**
 * Class BishopBlack решение задачи части 002 - Контрольные вопросы.  Решение задачи - Каркас шахматной доски.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
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
        int range = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[range];
        int deltaX = source.x > dest.x ? -1 : 1;
        int deltaY = source.y > dest.y ? -1 : 1;
        int x = source.x;
        int y = source.y;
        if (Math.abs(dest.y - source.y) != Math.abs(dest.x - source.x)) {
           throw new OccupiedWeyException("нельзя");
        }
        for (int i = 0; i < range; i++) {
            x += deltaX;
            y += deltaY;
            steps[i] = Cell.values()[8 * x + y];
       }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
