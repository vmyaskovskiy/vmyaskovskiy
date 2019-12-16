package ru.job4j;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.lyambda.SimpleQueue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;
    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
    }

    @Test
    public void poll4and3Push5Poll5() {
        assertThat(queue.poll(), is(1));
        queue.push(5);
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(5));
        queue.push(6); // в очереди не осталось элементов, добавили один элемент
        assertThat(queue.poll(), is(6)); // должен вернуться один единственный элемент
    }
}

