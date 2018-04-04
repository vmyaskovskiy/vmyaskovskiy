package ru.job4j.condition;

/**
 * Class Max тест задачи части 001 - урок Максимум из двух чисел 3.2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * метод maxN вычисляет максимальное значение из двух чисел.
     * @param  a входной параметр.
     * @param  b входной параметр.
     * @return max выходной параметр, возвращает максимальное значение из двух чисел.
     */

    public int maxN(int a, int b) {
       return a > b ? a : b;
    }
}
