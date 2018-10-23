package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.OccupiedWeyException;

/**
 * Class QeenBlack решение задачи части 002 - Контрольные вопросы.  Решение задачи - Каркас шахматной доски.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
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
        int range = 0;
        int rangeX = dest.x - source.x;
        int rangeY = dest.y - source.y;
        int deltaX = (int) Math.signum(rangeX);
        int deltaY = (int) Math.signum(rangeY);
        if (deltaX == 0 && deltaY != 0) {
            range = Math.abs(rangeY);
        } else if (deltaY == 0 && deltaX != 0) {
            range = Math.abs(rangeX);
        } else if (dest.x - source.x == 0) {
            range = Math.abs(rangeY);
        } else {
            range = Math.abs(rangeX);
        }
        if (deltaX != 0 && deltaY != 0 && (Math.abs(rangeY) != Math.abs(rangeX))) {
          throw new OccupiedWeyException("Нельзя так ходить");
        }
        Cell[] steps = new Cell[range];
        int x = source.x;
        int y = source.y;
        for (int i = 0; i < range; i++) {
            x += deltaX;
            y += deltaY;
            steps[i] = Cell.values()[8 * x + y];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
