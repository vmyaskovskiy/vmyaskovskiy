package ru.job4j.condition;

/**
 * Class Max тест задачи части 001 - урок Максимум из двух чисел 3.2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * метод для класса Max.
     * @param  a и  b  входные параметры.
     * @return max выходной параметр.
     */

    public int maxN(int a, int b) {
       return (a > b ? a : b);
    }
}
