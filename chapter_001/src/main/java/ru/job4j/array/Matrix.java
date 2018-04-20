package ru.job4j.array;
/**
 * Class Matrix решение задачи части 001 - урок Двухмерный массив. Таблица умножения. 5.4.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * метод multiple сортирует массив.
     * @param  size входной параметр - размер массива.
     * @return возвращает  массив заполненный результатами перемножения индексов ячеек.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
