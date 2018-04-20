package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class MatrixTest тестирование задачи части 001 - урок Двухмерный массив. Таблица умножения. 5.4.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class MatrixTest {
    @Test
    public void when2On2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
    @Test
    public void when1On1() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(1);
        int[][] expect = {
                {1}
        };
        assertThat(table, is(expect));
    }
    @Test
    public void when0On0() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(0);
        int[][] expect = {};
        assertThat(table, is(expect));
    }
}
