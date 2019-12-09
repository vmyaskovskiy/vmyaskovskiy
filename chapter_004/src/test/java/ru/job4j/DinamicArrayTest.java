package ru.job4j;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.lyambda.DinamicArray;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class DinamicArrayTest {
    private DinamicArray<Integer> array;

    @Before
    public void beforeTest() {
        array = new DinamicArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
    }
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(array.get(1), is(2));
    }
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(array.getSize(), is(3));
    }
    @Test
    public void whenDellOneElementsThenUseGetOneResultTwo() {
        Iterator<Integer> it;
        it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(array.getModCount(), is(3));
        //array.add(4); // java.util.ConcurrentModificationException
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
    @Test
    public void whenAdd4orElementsThenUseGetSizeResult6() {
        array.add(4);
        assertThat(array.getSize(), is(6));
    }
}
