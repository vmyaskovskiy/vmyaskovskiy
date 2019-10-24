package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.lyambda.ConverterIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertThat;

public class TestConverterIterator {
    @Test
    public void nextValue() {
        ConverterIterator con = new ConverterIterator();
        Iterator<Integer> itt = Arrays.asList(1).iterator();
        Iterator<Integer> itt1 = Arrays.asList(5).iterator();
        List<Iterator<Integer>> iteratorList = new ArrayList<>();
        iteratorList.add(itt);
        iteratorList.add(itt1);
        Iterator<Iterator<Integer>> iterator = iteratorList.iterator();
        Iterator<Integer> itt2 = con.convert(iterator);
        assertThat(itt2.hasNext(), Is.is(true));
        assertThat(itt2.next(), Is.is(1));
        assertThat(itt2.hasNext(), Is.is(true));
        assertThat(itt2.next(), Is.is(5));
        assertThat(itt2.hasNext(), Is.is(false));
    }
    @Test
    public void oneValue() {
        ConverterIterator con = new ConverterIterator();
        Iterator<Integer> itt = Arrays.asList(1).iterator();
        List<Iterator<Integer>> iteratorList = new ArrayList<>();
        iteratorList.add(itt);
        Iterator<Iterator<Integer>> iterator = iteratorList.iterator();
        Iterator<Integer> itt2 = con.convert(iterator);
        assertThat(itt2.hasNext(), Is.is(true));
        assertThat(itt2.next(), Is.is(1));
        assertThat(itt2.hasNext(), Is.is(false));
    }
    @Test
    public void manyValue() {
        ConverterIterator con = new ConverterIterator();
        Iterator<Integer> itt = Arrays.asList(1, 2).iterator();
        Iterator<Integer> itt1 = Arrays.asList(5).iterator();
        List<Iterator<Integer>> iteratorList = new ArrayList<>();
        iteratorList.add(itt);
        iteratorList.add(itt1);
        Iterator<Iterator<Integer>> iterator = iteratorList.iterator();
        Iterator<Integer> itt2 = con.convert(iterator);
        assertThat(itt2.hasNext(), Is.is(true));
        assertThat(itt2.hasNext(), Is.is(true));
        assertThat(itt2.next(), Is.is(1));
        assertThat(itt2.hasNext(), Is.is(true));
        assertThat(itt2.next(), Is.is(2));
        assertThat(itt2.hasNext(), Is.is(true));
        assertThat(itt2.next(), Is.is(5));
        assertThat(itt2.hasNext(), Is.is(false));
    }
}
