package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.Matrix;

import java.util.Arrays;

import static org.junit.Assert.assertThat;

public class TestMatrix {
    @Test
    public void matrixToList() {
        Integer[][] integers = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        Matrix matrix = new Matrix();
        assertThat(matrix.convertToMatrix(integers), Is.is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
