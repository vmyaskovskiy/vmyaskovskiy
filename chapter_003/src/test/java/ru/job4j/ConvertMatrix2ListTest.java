package ru.job4j;
import org.junit.Test;
import ru.job4j.array.ConvertMatrix2List;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ConvertMatrix2ListTest тестирование задачи части 003 - урок 4. Конвертация двумерного массива в ArrayList.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List res = new ConvertMatrix2List();
        int[][] array = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = res.toList(array);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expect));
    }
    @Test
    public void when4on2ArrayThenList8() {
        ConvertMatrix2List res = new ConvertMatrix2List();
        int[][] array = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        List<Integer> result = res.toList(array);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(result, is(expect));
    }

}
