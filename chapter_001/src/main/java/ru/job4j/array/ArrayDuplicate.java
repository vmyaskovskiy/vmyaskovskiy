package ru.job4j.array;

import java.util.Arrays;
/**
 * Class ArrayDuplicate решение задачи части 001 - урок Удаление дубликатов в массиве. 5.5.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * метод multiple сортирует массив.
     * @param  array входной параметр -  массив из слов в котором возможны дубликаты.
     * @return out возвращает  массив с удаленными дубликатами.
     */
    String[] remove(String[] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    k = k + 1;
                    if (j != array.length - 1) {
                        String temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                        i = i + 1;
                    }
                }
            }
        }
            return Arrays.copyOf(array, array.length - k);
        }
    }

