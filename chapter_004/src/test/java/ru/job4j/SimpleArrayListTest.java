package ru.job4j;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.lyambda.SimpleArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
    // проверка , какой первый элемент
    // проверка удаления
    // проверка, что после удаления, первым стал элемент, который был вторым
    // проверка, что после удаления, уменьшился размер коллекции
    // проверка, что не поломалось добавление элемента
    @Test
    public void whenDellOneElementsThenUseGetOneResultTwo() {
        assertThat(list.get(0), is(3));
        list.delete();
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(2));
        list.add(4);
        assertThat(list.get(0), is(4));
        assertThat(list.getSize(), is(3));
    }

}
