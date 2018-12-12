package ru.job4j;

import org.junit.Test;
import ru.job4j.array.PriorityQueue;
import ru.job4j.array.Task;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class PriorityQueue тестирование задачи части 003 - урок 2. Очередь с приоритетом на LinkedList.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue res = new PriorityQueue();
        res.put(new Task("High", 1));
        res.put(new Task("Midl", 2));
        res.put(new Task("Low", 3));
        res.put(new Task("Low1", 3));
        assertThat(res.take().getDesk(), is("High"));
    }
    @Test
    public void whenHigherPriorityLast() {
        PriorityQueue res = new PriorityQueue();
        res.put(new Task("Low", 3));
        res.put(new Task("Low1", 3));
        res.put(new Task("Midl", 2));
        res.put(new Task("High", 1));
        assertThat(res.take().getDesk(), is("High"));
    }
    @Test
    public void whenHigherPriorityMixOne() {
        PriorityQueue res = new PriorityQueue();
        res.put(new Task("High", 1));
        res.put(new Task("Low",  3));
        res.put(new Task("Low1", 3));
        res.put(new Task("Midl", 2));
        assertThat(res.take().getDesk(), is("High"));
        assertThat(res.take().getDesk(), is("Midl"));
        assertThat(res.take().getDesk(), is("Low1"));
    }
    @Test
    public void whenHigherPriorityMixTwo() {
        PriorityQueue res = new PriorityQueue();
        res.put(new Task("Midl", 2));
        res.put(new Task("Low", 3));
        res.put(new Task("High1", 1));
        res.put(new Task("Low1", 3));
        res.put(new Task("High", 1));
        assertThat(res.take().getDesk(), is("High1"));
    }
}
