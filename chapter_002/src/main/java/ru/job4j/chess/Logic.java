package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.OccupiedWeyException;

import java.io.ObjectStreamException;
import java.util.Optional;

/**
 * Class Logic решение задачи части 002 - Контрольные вопросы.  Решение задачи - Каркас шахматной доски.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }
    /**
     * Метод move просчитывает возможность двигаться фигуре, если встречаются исключения они обрабатываются.
     * @param source  координаты ячейки откуда ходят
     * @param dest  координаты ячейки куда ходят
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWeyException {
        boolean rst = false;
        int index = this.findBy(source);
        int indexDest = this.findBy(dest);
        if (index != -1 && indexDest == -1) {
            try {
                Cell[] steps = this.figures[index].way(source, dest);
                for (int i = 0; i < steps.length; i++) {
                    if (this.findBy(steps[i]) != -1) {
                        throw new OccupiedWeyException("на пути стоит фигура");
                    }
                    if (steps[i].equals(dest)) {
                        rst = true;
                        this.figures[index] = this.figures[index].copy(steps[i]);
                        break;
                    }
                }
            }
            catch (ImpossibleMoveException ime) {
                this.figures[index] = this.figures[index].copy(source);
                System.out.println(ime.getMessage());
            }
            catch (OccupiedWeyException owe) {
                this.figures[index] = this.figures[index].copy(source);
                System.out.println(owe.getMessage());
            }
        }
            return rst;
        }
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
