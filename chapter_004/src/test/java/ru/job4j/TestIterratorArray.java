package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.IterratorArray;

import static org.junit.Assert.assertThat;

public class TestIterratorArray {
    @Test
    public void nextValue() {
        IterratorArray it = new IterratorArray(new int[][]{{1, 2}, {3, 4, 5}, {6}});
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(true));
    }
    @Test
    public void nextValueThenLastValue() {
        IterratorArray it = new IterratorArray(new int[][]{{1}, {3}});
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(false));
    }
    @Test
    public void nextValueLongArray() {
        IterratorArray it = new IterratorArray(new int[][] {{1}, {2, 3, 4, 5}, {6, 7}, {8, 9, 10, 11, 12, 13, 14}});
        Object res1 = it.next();
        Object res2 = it.next();
        Object res3 = it.next();
        Object res4 = it.next();
        Object res5 = it.next();
        Object res6 = it.next();
        boolean resV = it.hasNext();
        assertThat(res6, Is.is(6));
        assertThat(resV, Is.is(true));
    }
    @Test
    public void nextValueThenLastValueNull() {
        IterratorArray it = new IterratorArray(new int[][]{{1}, {}, {3}});
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(false));
    }

    @Test
    public void nextValueTwo() {
        IterratorArray it = new IterratorArray(new int[][]{{1}, {}, {}, {3, 4}});
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(4));
        assertThat(it.hasNext(), Is.is(false));
    }
}
