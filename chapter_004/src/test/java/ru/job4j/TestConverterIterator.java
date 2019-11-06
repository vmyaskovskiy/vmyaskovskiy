package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.lyambda.ConverterIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
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
        assertThat(itt2.hasNext(), is(true));
        assertThat(itt2.next(), is(1));
        assertThat(itt2.hasNext(), is(true));
        assertThat(itt2.next(), is(5));
        assertThat(itt2.hasNext(), is(false));
    }
    @Test
    public void oneValue() {
        ConverterIterator con = new ConverterIterator();
        Iterator<Integer> itt = Arrays.asList(1).iterator();
        List<Iterator<Integer>> iteratorList = new ArrayList<>();
        iteratorList.add(itt);
        Iterator<Iterator<Integer>> iterator = iteratorList.iterator();
        Iterator<Integer> itt2 = con.convert(iterator);
        assertThat(itt2.hasNext(), is(true));
        assertThat(itt2.next(), is(1));
        assertThat(itt2.hasNext(), is(false));
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
        assertThat(itt2.hasNext(), is(true));
        assertThat(itt2.hasNext(), is(true));
        assertThat(itt2.next(), is(1));
        assertThat(itt2.hasNext(), is(true));
        assertThat(itt2.next(), is(2));
        assertThat(itt2.hasNext(), is(true));
        assertThat(itt2.next(), is(5));
        assertThat(itt2.hasNext(), is(false));
    }

    @Test
    public void hasNextShouldReturnTrueInCaseOfEmptySameIterators() {
        ConverterIterator con = new ConverterIterator();
        Iterator<Integer> itt = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> itt1 = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> itt2 = Arrays.asList(1).iterator();
        List<Iterator<Integer>> iteratorList = Arrays.asList(itt, itt1, itt2);
        Iterator<Iterator<Integer>> iterator = iteratorList.iterator();
        Iterator<Integer> itt3 = con.convert(iterator);
        assertThat(itt3.hasNext(), is(true));
        assertThat(itt3.next(), is(1));
        assertThat(itt3.hasNext(), is(false));
    }
    @Test
    public void hasNextShouldReturnFalseInCaseOfEmptyIterators() {
        ConverterIterator con = new ConverterIterator();
        Iterator<Integer> itt = (new ArrayList<Integer>()).iterator();
        Iterator<Integer> itt1 = (new ArrayList<Integer>()).iterator();
        List<Iterator<Integer>> iteratorList = Arrays.asList(itt, itt1);
        Iterator<Iterator<Integer>> iterator = iteratorList.iterator();
        Iterator<Integer> itt3 = con.convert(iterator);
        assertThat(itt3.hasNext(), is(false));
    }

    Iterator<Integer> it;

    @Before
    public void setUp() {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        ConverterIterator iteratorOfIterators = new ConverterIterator();
        it = iteratorOfIterators.convert(its);
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
    }


}
