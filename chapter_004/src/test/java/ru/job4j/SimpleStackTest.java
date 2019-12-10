package ru.job4j;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.lyambda.SimpleStack;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    private SimpleStack<Integer> stack;
    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }

    @Test
    public void poll4and3Push5Poll5() {
        assertThat(stack.poll(), is(4));
        assertThat(stack.poll(), is(3));
        stack.push(5);
        assertThat(stack.poll(), is(5));
    }
}
