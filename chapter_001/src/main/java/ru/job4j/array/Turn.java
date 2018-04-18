package ru.job4j.array;

/**
 * Class Turn решение задачи части 001 - урок Перевернуть массив. 5.2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    /**
     * метод turn Переворачивает массив.
     * @param  array входной параметр - массив.
     * @return возвращает перевернутый массив.
     */
    public int[] turn(int[] array) {
        int k = array.length / 2;
        for (int i = 0; i <=  k; i++) {
            if (i <= k - 1) {
                int  intTemp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = intTemp;
            }
        }
        return array;
    }
}
