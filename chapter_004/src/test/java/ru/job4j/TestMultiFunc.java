package ru.job4j;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.MultyFunc;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class TestMultiFunc {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        MultyFunc func = new MultyFunc();
        List<Double> result = func.multiple(5, 8,
                x -> 2 * x + 1);
        assertThat(result, Is.is(Arrays.asList(11D, 13D, 15D)));
    }
    @Test
    public void whenQadroFunctionThenQadroResults() {
        MultyFunc func = new MultyFunc();
        List<Double> result = func.multiple(5, 8,
                x ->  x * x);
        assertThat(result, Is.is(Arrays.asList(25D, 36D, 49D)));
    }
    @Test
    public void whenLogFunctionThenLogResults() {
        MultyFunc func = new MultyFunc();
        List<Double> result = func.multiple(5, 8,
                x ->  Math.log(x));
        assertThat(result.get(0), Matchers.closeTo(1.6, 0.1));
    }

}
