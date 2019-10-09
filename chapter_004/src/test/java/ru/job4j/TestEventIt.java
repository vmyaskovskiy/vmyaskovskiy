package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.EventIt;

import static org.junit.Assert.assertThat;

public class TestEventIt {
    @Test
    public void nextValueThenLastValueNoSuchElementException() {
        EventIt it = new EventIt(new int[]{1, 2});
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(false));
        // assertThat(it.next(), Is.is(2)); // MyException: NoSuchElementException
    }
    @Test
    public void nextValueThenLastValue() {
        EventIt it = new EventIt(new int[]{4, 2, 1, 1});
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(4));
        assertThat(it.hasNext(), Is.is(false));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(false));
        // assertThat(it.next(), Is.is(2)); // MyException: NoSuchElementException
    }
    @Test
    public void nextValueThenLastValueNoValue() {
        EventIt it = new EventIt(new int[]{1, 1});
        assertThat(it.hasNext(), Is.is(false));
        //assertThat(it.next(), Is.is(2));// MyException: NoSuchElementException
    }
    @Test
    public void nextValueThenLongValue() {
        EventIt it = new EventIt(new int[]{1, 1, 1, 2});
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(false));
       // assertThat(it.next(), Is.is(2));// MyException: NoSuchElementException
        assertThat(it.hasNext(), Is.is(false));
    }
}
