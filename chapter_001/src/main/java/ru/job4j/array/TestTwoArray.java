package ru.job4j.array;
import java.util.Arrays;
/**
 * Class TestTwoArray тестовой дополнительной задачи части 001.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestTwoArray {
    /**
     * метод merge сливает два не отсортированных массива и сортирует массив.
     * @param  left, right входные параметры - массивы.
     * @return возвращает отсортированный массив.
     */
    public int[] merge(int[] left, int[] right) {
        int k = left.length;
        int g = right.length;
        int r = left.length + right.length;
        int[] leftRight = new int[r];
        for (int i = 0; i < k; i++) {
            leftRight[i] = left[i];
        }
        for (int j = 0; j < g; j++) {
            leftRight[j + k] = right[j];
        }
        BubbleSort bubbleSort = new BubbleSort();
        int[] mergeArray = bubbleSort.bubbleSort(leftRight);
        return mergeArray;
    }
    /**
     * метод mergeTwo сливает два отсортированных массива в отсортированный массив.
     * @param  left, right входные параметры - массивы.
     * @return возвращает отсортированный массив.
     */
    public int[] mergeTwo(int[] left, int[] right) {
        int l = left.length;
        int r = right.length;
        int g = left.length + right.length;
        int k = 0;
        int h = 0;
        int z = 0;
        int[] leftRightTwo = new int[g];
          for (int i = 0; i < l; i++) {
              for (int j = 0; j < r; j++) {
                  if (left[i] < right[j]) {
                      leftRightTwo[k] = left[i];
                      k++;
                      i++;
                      z++;
                      j--;
                        if (i == l) {
                            for (j = h; j < r; j++) {
                                leftRightTwo[k] = right[j];
                                k++;
                            }
                        }
                  } else {
                  leftRightTwo[k] = right[j];
                  k++;
                  h++;
                    if (j == r - 1) {
                        for (i = z; i < l; i++) {
                            leftRightTwo[k] = left[i];
                            k++;
                        }
                    }
                  }
              }
          }
        return leftRightTwo;
        }
    }

