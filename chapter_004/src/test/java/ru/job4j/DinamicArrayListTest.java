package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.lyambda.DinamicArrayList;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class DinamicArrayListTest {
    private DinamicArrayList<Integer> list;
    @Before
    public void beforeTest() {
        list = new DinamicArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void add5() {
        list.add(5);
        assertThat(list.get(0), is(5));
        assertThat(list.getModCount(), is(5));
        list.add(6);
        assertThat(list.getModCount(), is(6));
    }
    @Test
    public void nestHasNext() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
    }
}
