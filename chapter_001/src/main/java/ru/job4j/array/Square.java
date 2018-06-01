package ru.job4j.array;
/**
 * Class Square решение задачи части 001 - урок Заполнить массив степенями чисел. 5.0.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * метод calculate Заполнить массив степенями чисел.
     * @param  bound входной параметр количество чисел в массиве.
     * @return возвращает массив заполненный степенями чисел.
     */
    public int[] calculate(int bound) {
        int[] res = new int[bound];
        for (int index = 0; index != res.length; index++) {
            int i = index + 1;
            res[index] = (int) Math.pow(i, 2);
        }
        return res;
    }
}
