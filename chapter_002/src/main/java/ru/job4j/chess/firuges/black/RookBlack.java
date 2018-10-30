package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * Class BishopBlack решение задачи части 002 - Контрольные вопросы.  Решение задачи - Каркас шахматной доски.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }
    /**
     * Метод way просчитывает правильный путь фигуры, выдает исключение если фигура движется неправильн.
     * @param source  координаты ячейки откуда ходят
     * @param dest  координаты ячейки куда ходят
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        int range;
        if (dest.x - source.x == 0) {
            range = Math.abs(dest.y - source.y);
        } else {
            range = Math.abs(dest.x - source.x);
        }
        Cell[] steps = new Cell[range];
        int deltaX = (int) Math.signum(dest.x - source.x);
        int deltaY = (int) Math.signum(dest.y - source.y);
                int x = source.x;
                int y = source.y;
                for (int i = 0; i < range; i++) {
                    if ((deltaX == 1 && deltaY == 0)
                            || (deltaX == -1 && deltaY == 0)
                            || (deltaX == 0 && deltaY == 1)
                            || (deltaX == 0 && deltaY == -1)) {
                        x += deltaX;
                        y += deltaY;
                        steps[i] = Cell.values()[8 * x + y];
                    } else {
                        throw new ImpossibleMoveException("Так нельзя ходить");
                    }
                }
                return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
