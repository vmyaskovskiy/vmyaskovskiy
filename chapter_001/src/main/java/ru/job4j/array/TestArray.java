package ru.job4j.array;
/**
 * Class TestArray решение тестовой дополнительной задачи части 001.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestArray {
    /**
     * метод arrayTestUp проверяет массив на упорядочность по возрастанию.
     * @param array входной параметр - массив.
     * @return возвращает true если массив упорядочен по возрастанию.
     */
    public boolean arrayTestUp(int[] array) {
        boolean r = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                r = false;
            }
        }
        return r;
    }
    /**
     * метод arrayTestDown проверяет массив на упорядочность по убыванию.
     * @param array входной параметр - массив.
     * @return возвращает true если массив упорядочен по убыванию.
     */
    public boolean arrayTestDown(int[] array) {
        boolean r = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                r = false;
            }
        }
        return r;
    }
}


