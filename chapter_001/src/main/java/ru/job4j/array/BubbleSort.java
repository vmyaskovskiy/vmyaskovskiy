package ru.job4j.array;
/**
 * Class BubbleSort решение задачи части 001 - урок Создать программу для сортировки массива методом перестановки. 5.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * метод bubbleSort сортирует массив.
     * @param  array входной параметр - массив.
     * @return возвращает отсортированный массив.
     */
    public int[] bubbleSort(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (array[i] > array[j]) {
                    int tempA = array[i];
                    array[i] = array[j];
                    array[j] = tempA;
                }
            }
        }
        return array;
    }
}
