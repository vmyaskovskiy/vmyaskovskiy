package ru.job4j.array;
/**
 * Class MatrixCheck решение задачи части 001 - урок Квадратный массив заполнен true или false по диагоналям. 6.7.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * метод mono сортирует массив.
     * @param  data входной параметр -  массив.
     * @return возвращает true если массив заполнен true или false по диагоналям.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int k = data.length - 1;
        int j = 0;
        for (int i = 0; i < k; i++) {
            if ((data[i][j] != data[i + 1][j + 1]) || (data[i][k - i] != data[i + 1][k - i - 1])) {
                result = false;
            }
        }
        return result;
    }
}