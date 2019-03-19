package ru.job4j.array;

import java.util.ArrayList;
import java.util.List;
/**
 * Class ConvertMatrix2List решение задачи части 003 - урок 4. Конвертация двумерного массива в ArrayList.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] innerArray : array) {
            for (int res : innerArray) {
                list.add(res);
            }
        }
        return list;
    }
}
