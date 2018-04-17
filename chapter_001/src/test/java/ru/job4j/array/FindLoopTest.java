package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FindLoopTest тестирование задачи части 001 - урок Классический поиск перебором. 5.1.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class FindLoopTest {
    @Test
    //ищем индекс элемента со значением 5.
    public void whenArrayHasLengh5Then0() {
        int el = 5;
        FindLoop findLoop = new FindLoop();
        int[] input = new int[] {5, 10, 2};
        int res = findLoop.indexOf(input, el);
        int expect = 0;
        assertThat(res, is(expect));
    }

    @Test
    //если искомого элемента нет в массиве результат -1.
    public void whenArrayNotHas5ThenMinusOne() {
        FindLoop findLoop = new FindLoop(); //класс объявили
        int el = 5; // задали какой элемент будем искать
        int[] data = new int[] {0, 10, 3}; //заполнили массив данными, где будет искомый элемент
        int res = findLoop.indexOf(data, el); // вызвали метод из класса , передали в него заполненный массив и искомый элемент
        int expect = -1; // ожидаем - 1 , так как искомого элемента нет в массиве
        assertThat(res, is(expect)); // сравниваем результат метода и ожидаемый результат
    }
}
