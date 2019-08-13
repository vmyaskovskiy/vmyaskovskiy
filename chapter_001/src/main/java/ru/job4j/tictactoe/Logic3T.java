package ru.job4j.tictactoe;
// на 11 JDK
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
    public boolean isWinnerX() {
        Figure3T[][] table = this.table;

        return this.checkMarkX(table, 0, 1, 0, 0, 0, 0)
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
        Figure3T[][] table = this.table;
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
        Figure3T[][] table = this.table;
        boolean result = true;
        int k = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j].hasMarkX() || table[i][j].hasMarkO()) {
                  k++;
                    if (k == 9) {
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

