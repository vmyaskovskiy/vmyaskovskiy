package ru.job4j.loop;

/**
 * Class Counter решение задачи части 001 - урок Создать программу вычисляющую факториал. 4.2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class Factorial {
    /**
     * метод calc вычисляет факториал.
     * @param  n входной параметр.
     * @return res выходной параметр, возвращает значение факториала N.
     */
   public int calc(int n) {
       int res = 1;
       if (n != 0) {
           for (int i = 1; i <= n; i++) {
               res *= i;
           }
       }
       return res;
   }
}
