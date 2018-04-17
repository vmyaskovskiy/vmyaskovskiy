package ru.job4j.array;

/**
 * Class FindLoop решение задачи части 001 - урок Классический поиск перебором. 5.1.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int res = -1;
        for (int i = 0; i != 3; i++) {
            if (data[i] == el) {
                res = i;
                break;
            }
        }
        return res;
    }
}
