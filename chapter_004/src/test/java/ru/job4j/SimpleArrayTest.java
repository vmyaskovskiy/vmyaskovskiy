package ru.job4j;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.lyambda.SimpleArray;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    private SimpleArray<Integer> array;
    @Before
    public void beforeTest() {
        array = new SimpleArray<>(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
    }
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(array.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(array.getLength(), is(5));
        assertThat(array.getSize(), is(5));
    }
    @Test
    public void nestHasNext() {
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        it.next();
        assertThat(it.hasNext(), is(false));
    }

}
