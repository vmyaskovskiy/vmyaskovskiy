package ru.job4j;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.lyambda.SimpleSet;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    SimpleSet<Integer> set = new SimpleSet<>();
    @Before
    public void beforeTest() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
    }

    @Test
    public void getValueTest() {
        assertThat(set.getValue(1), is(true));
        assertThat(set.getValue(6), is(false));
    }
    @Test
    public void add5Then5IsInArrayTest() {
        assertThat(set.add(5), is(false));
        assertThat(set.get(4), is(5));
       // assertThat(set.get(5), is("java.util.NoSuchElementException"));
        assertThat(set.getValue(6), is(false));
    }

    @Test
    public void iteratorTest() {
        Iterator<Integer> it;
        it = set.iterator();
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
        assertThat(it.hasNext(), is(false));
    }
}
