package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ArrayCharTest тестирование задачи части 001 - урок Слова начинается с ... 5.5.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        boolean res = arrayChar.startWith("He");
        assertThat(res, is(true));
    }
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar arrayChar = new ArrayChar("Hello");
        boolean res = arrayChar.startWith("Hi");
        assertThat(res, is(false));
    }

}
