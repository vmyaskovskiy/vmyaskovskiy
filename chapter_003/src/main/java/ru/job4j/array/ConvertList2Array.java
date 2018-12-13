package ru.job4j.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Class ConvertList2ArrayTest решение задачи части 003 - урок Конвертация ArrayList в двухмерный массив.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        int cells = (int)Math.ceil((double) size / rows);
        int[][] array = new int[rows][cells];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (k < size) {
                array[i][j] = list.get(k);
                k++;
                } else {array[i][j] = 0;}
            }
        }
        return array;
    }
}
