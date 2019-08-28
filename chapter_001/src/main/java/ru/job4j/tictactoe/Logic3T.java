package ru.job4j.tictactoe;
// на 11 JDK

import java.util.function.Predicate;

/**
 * Class Logic3T решение задачи части 001 - урок Крестики-нолики на JavaFX, отвечает за проверку логики.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Logic3T {
    private final Figure3T[][] table;
    /**
     * метод checkMarkX проверяет выигрышные комбинации для Х.
     * @param  table входной параметр -  массив.
     * @return возвращает true если выпадают выигрышные комбинации для Х.
     */
    public boolean checkMarkX(Figure3T[][] table, int di, int dj, int j, int i, int ti, int tj) {
        boolean res = false;

            if ((table[i + ti][j + tj].hasMarkX() && table[i + di + ti][j + dj + tj].hasMarkX() && table[i + 2 * di + ti][j + 2 * dj + tj].hasMarkX())) {
                res = true;
            }
            return res;
        }
    /**
     * метод checkMarkO проверяет выигрышные комбинации для О.
     * @param  table входной параметр -  массив.
     * @return возвращает true если выпадают выигрышные комбинации для О.
     */
    public boolean checkMarkO(Figure3T[][] table, int di, int dj, int j, int i, int ti, int tj) {
        boolean res = false;
        if ((table[i + ti][j + tj].hasMarkO() && table[i + di + ti][j + dj + tj].hasMarkO() && table[i + 2 * di + ti][j + 2 * dj + tj].hasMarkO())) {
            res = true;
        }
        return res;
    }
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerXNew() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1) ||
                this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0);

    }
    public boolean isWinnerONew() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1 , 0, -1, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0);

    }

    public boolean isWinnerX() {

        return this.checkMarkX(this.table, 0, 1, 0, 0, 0, 0)
                ||
                this.checkMarkX(table, 0, 1, 0, 0, 1, 0)
                ||
                this.checkMarkX(table, 0, 1, 0, 0, 2, 0)
                ||
                this.checkMarkX(table, 1, 1, 0, 0, 0, 0)
                ||
                this.checkMarkX(table, 1, -1, 2, 0, 0, 0)
                ||
                this.checkMarkX(table, 1, 0, 0, 0, 0, 0)
                ||
                this.checkMarkX(table, 1, 0, 0, 0, 0, 1)
                ||
                this.checkMarkX(table, 1, 0, 0, 0, 0, 2);
    }

    public boolean isWinnerO() {

        return this.checkMarkO(table, 0, 1, 0, 0, 0, 0)
                ||
                this.checkMarkO(table, 0, 1, 0, 0, 1, 0)
                ||
                this.checkMarkO(table, 0, 1, 0, 0, 2, 0)
                ||
                this.checkMarkO(table, 1, 1, 0, 0, 0, 0)
                ||
                this.checkMarkO(table, 1, -1, 2, 0, 0, 0)
                ||
                this.checkMarkO(table, 1, 0, 0, 0, 0, 0)
                ||
                this.checkMarkO(table, 1, 0, 0, 0, 0, 1)
                ||
                this.checkMarkO(table, 1, 0, 0, 0, 0, 2);
    }
    /**
     * метод hasGap проверяет , что все клетки заполнены.
     * @return возвращает true если все клетки заполнены.
     */
    public boolean hasGap() {
        boolean result = true;
        int k = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j].hasMarkX() || table[i][j].hasMarkO()) {
                  k++;
                    if (k == table.length * table.length) {
                        result = false;
                    } else {
                        result = true;
                      }
                    }
                  }
                }
        return result;
       }
}

