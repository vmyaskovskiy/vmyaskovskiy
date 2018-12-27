package ru.job4j;

import org.junit.Test;
import ru.job4j.array.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ConvertList2ArrayTest тестирование задачи части 003 - урок Конвертация ArrayList в двухмерный массив.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
       ConvertList2Array res = new ConvertList2Array();
        int[][] result = res.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}
        };
     assertThat(result, is(expect));
    }
    @Test
    public void when5ElementsThen6() {
        ConvertList2Array res = new ConvertList2Array();
        int[][] result = res.toArray(Arrays.asList(1, 2, 3, 4, 5), 2);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when6ElementsThen6() {
        ConvertList2Array res = new ConvertList2Array();
        int[][] result = res.toArray(Arrays.asList(1, 2, 3, 4, 5, 6), 2);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when6ElementsThen8and4Rows() {
        ConvertList2Array res = new ConvertList2Array();
        int[][] result = res.toArray(Arrays.asList(1, 2, 3, 4, 5, 6), 4);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void convertToListTest() {
        ConvertList2Array res = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add( new int[] {1,2});
        list.add(new int[] {1,2,3});
        list.add(new int[] {0,5,6,4,8});
        List<Integer> expect = Arrays.asList(1, 2, 1, 2, 3, 0, 5, 6, 4, 8);
        assertThat(res.convertToList(list), is(expect));
    }
}
