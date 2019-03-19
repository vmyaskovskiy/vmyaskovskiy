package ru.job4j;
import org.junit.Test;
import ru.job4j.array.ListCompare;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ListCompareTest тестирование задачи части 003 - 3. Компаратор для строк.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ListCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare list = new ListCompare();
        String res1 = "Ivanov";
        String res2 = "Ivanov";
        assertThat(list.compare(res1, res2), is(0));
    }
    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare list = new ListCompare();
        String res1 = "Ivanov";
        String res2 = "Ivanova";
        assertThat(list.compare(res1, res2), lessThan(0));
    }
    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare list = new ListCompare();
        String res1 = "Petrov";
        String res2 = "Ivanova";
        assertThat(list.compare(res1, res2), greaterThan(0));
    }
    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositiveTwo() {
        ListCompare list = new ListCompare();
        String res1 = "Ivanov";
        String res2 = "Patrova";
        assertThat(list.compare(res1, res2), lessThan(0));
    }
    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare list = new ListCompare();
        String res1 = "Petrov";
        String res2 = "Patrov";
        assertThat(list.compare(res1, res2), greaterThan(0));
    }
    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare list = new ListCompare();
        String res1 = "Patrova";
        String res2 = "Petrov";
        assertThat(list.compare(res1, res2), lessThan(0));
    }
    @Test
    public void whenLeftGreaterThanRightResultShouldBePositiveTwo() {
        ListCompare list = new ListCompare();
        String res1 = "Patrova";
        String res2 = "Patrov";
        assertThat(list.compare(res1, res2), greaterThan(0));
    }
}
