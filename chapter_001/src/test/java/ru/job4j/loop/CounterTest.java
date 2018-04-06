package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest тестирование задачи части 001 - урок Подсчет суммы чётных чисел в диапазоне 4.1.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {
    @Test
    // Проверка правильности подсчета от 1 до 10 = 30
    public void addTest() {
        Counter counter = new Counter();
        int res = counter.add(1, 10);
        assertThat(res, is(30));
    }
    @Test
    // проверка от минус 10 до плюс 10 = 0
    public void addTestZero() {
        Counter counter = new Counter();
        int res = counter.add(-10, 10);
        assertThat(res, is(0));
    }
    @Test
    // проверка если диапазон нулевой
    public void addTestZeroZero() {
        Counter counter = new Counter();
        int res = counter.add(0, 0);
        assertThat(res, is(0));
    }
    @Test
    // проверка если в диапазоне нет четных чисел
    public void addTestZeroToOne() {
        Counter counter = new Counter();
        int res = counter.add(0, 1);
        assertThat(res, is(0));
    }
    @Test
    // проверка диапазаона от нечетного до нечетного
    public void addTestOneToThree() {
        Counter counter = new Counter();
        int res = counter.add(0, 3);
        assertThat(res, is(2));
    }
    @Test
    // проверка диапазаона от четного до четного
    public void addTestTwoToFour() {
        Counter counter = new Counter();
        int res = counter.add(2, 4);
        assertThat(res, is(6));
    }
}
