package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.lyambda.SimpleArray;

import java.util.Iterator;

import static org.junit.Assert.assertThat;

public class TestSimpleArray {
    SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
    @Before
    public void setUp() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
    }
    @Test
    public void testInteger() {
        assertThat(simpleArray.get(0), Is.is(1));
        simpleArray.set(0, 2);
        assertThat(simpleArray.get(0), Is.is(2));
        simpleArray.remove(0);
        assertThat(simpleArray.get(1), Is.is(3));
        Iterator<Integer> intInteger = simpleArray.iterator();
        assertThat(intInteger.hasNext(), Is.is(true));
        assertThat(intInteger.hasNext(), Is.is(true));
        assertThat(intInteger.next(), Is.is(2));
        assertThat(intInteger.hasNext(), Is.is(true));
        assertThat(intInteger.next(), Is.is(3));
        assertThat(intInteger.hasNext(), Is.is(true));
        assertThat(intInteger.next(), Is.is(4));
        assertThat(intInteger.hasNext(), Is.is(false));
    }
    SimpleArray<String> simpleArrayStr = new SimpleArray<>(3);
    @Before
    public void setUpTwo() {
        simpleArrayStr.add("Test1");
        simpleArrayStr.add("Test2");
        simpleArrayStr.add("Test3");
    }
    @Test
    public void testString() {
        assertThat(simpleArrayStr.get(0), Is.is("Test1"));
        simpleArrayStr.set(0, "Test4");
        assertThat(simpleArrayStr.get(0), Is.is("Test4"));
        simpleArrayStr.remove(0);
        assertThat(simpleArrayStr.get(1), Is.is("Test3"));
        Iterator<String> intString = simpleArrayStr.iterator();
        assertThat(intString.hasNext(), Is.is(true));
        assertThat(intString.hasNext(), Is.is(true));
        assertThat(intString.next(), Is.is("Test2"));
        assertThat(intString.hasNext(), Is.is(true));
        assertThat(intString.next(), Is.is("Test3"));
        assertThat(intString.hasNext(), Is.is(false));
    }
}
