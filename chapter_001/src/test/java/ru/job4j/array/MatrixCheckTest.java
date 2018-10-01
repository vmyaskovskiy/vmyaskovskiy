package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MatrixCheck решение задачи части 001 - урок Квадратный массив заполнен true или false по диагоналям. 6.7.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheckTest {
    @Test
    public void matrixTestOne() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] data = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean res = matrixCheck.mono(data);
        assertThat(res, is(true));
    }
    @Test
    public void matrixTestTwo() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] data = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean res = matrixCheck.mono(data);
        assertThat(res, is(false));
    }
    @Test
    public void matrixTestTree() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] data = new boolean[][] {
                {true, false},
                {false, true}
        };
        boolean res = matrixCheck.mono(data);
        assertThat(res, is(true));
    }
}
