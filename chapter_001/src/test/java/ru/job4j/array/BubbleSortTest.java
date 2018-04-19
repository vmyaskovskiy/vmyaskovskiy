package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSortTest тестирование задачи части 001 - урок Создать программу для сортировки массива методом перестановки. 5.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {
    @Test
    public void bubbleSort51273To12357() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] expect = new int[] {1, 2, 3, 5, 7};
        int[] array = new int[] {5, 1, 2, 7, 3};
        int[] res = bubbleSort.bubbleSort(array);
        assertThat(res, is(expect));
    }
    @Test
    public void bubbleSort1542317805To0112345578() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        int[] array = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] res = bubbleSort.bubbleSort(array);
        assertThat(res, is(expect));
    }
    @Test
    public void bubbleSort1111To1111() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] expect = new int[] {1, 1, 1, 1};
        int[] array = new int[] {1, 1, 1, 1};
        int[] res = bubbleSort.bubbleSort(array);
        assertThat(res, is(expect));
    }
}
