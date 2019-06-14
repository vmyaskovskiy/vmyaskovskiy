package ru.job4j;

import org.junit.Test;
import ru.job4j.lyambda.Calc;
import ru.job4j.lyambda.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestCalc {
    @Test
    public void whenAddUtil3() {
        Calc calc = new Calc();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value * index,
                result -> buffer.add(result)
        );
        assertThat(buffer, is(Arrays.asList(0D, 1D, 2D)));
    }
    @Test
    public void whenAddUtil13Two() {
        Calc calc = new Calc();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(0, 3, 1,
                MathUtil::add,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}
