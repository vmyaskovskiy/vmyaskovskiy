package ru.job4j.loop;
/**
 * Class Counter решение задачи части 001 - урок Подсчет суммы чётных чисел в диапазоне 4.1.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * метод add Подсчет суммы чётных чисел в диапазоне.
     * @param  start входной параметр - начало диапазона.
     * @param  finish входной параметр- конец диапазона.
     * @return res выходной параметр, возвращает сумму чётных чисел в диапазоне.
     */
   public int add(int start, int finish) {
        int res = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                res += i;
            }
        }
        return res;
    }
}
