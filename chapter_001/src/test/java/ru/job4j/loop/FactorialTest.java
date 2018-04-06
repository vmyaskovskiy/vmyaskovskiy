package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest автотест задачи части 001 - урок Создать программу вычисляющую факториал. 4.2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class FactorialTest {

    @Test
    // вычисление факториала 5 равно 120.
    public void factorialFife() {
        Factorial factorial = new Factorial();
        int res = factorial.calc(5);
        assertThat(res, is(120));
    }

    @Test
    // вычисление факториала 0 равно 1.
    public void factorialZeroOnOne() {
        Factorial factorial = new Factorial();
        int res = factorial.calc(0);
        assertThat(res, is(1));
    }
}
