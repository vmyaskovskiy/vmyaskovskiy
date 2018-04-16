package ru.job4j.array;

/**
 * Class SquareTest тестирование задачи части 001 - урок Заполнить массив степенями чисел. 5.0.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    // проверка возведения в квадрат чисел 1 2 3  результат должен быть 1 4 9.
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] res = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(res, is(expect));
    }
    @Test
    // проверка возведения в квадрат чисел 1 2 3 4 5  результат должен быть 1 4 9 16 25.
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] res = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(res, is(expect));
    }
    @Test
    // проверка возведения в квадрат чисел 0  результат должен быть 0.
    public void whenBound0ThenNull() {
        int bound = 0;
        Square square = new Square();
        int[] res = square.calculate(bound);
        int[] expect = new int[] {};
        assertThat(res, is(expect));
    }
}
