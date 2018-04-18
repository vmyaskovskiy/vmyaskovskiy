package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TurnTest тестирование задачи части 001 - урок Перевернуть массив. 5.2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class TurnTest {
    @Test
    public void arrayTurn1234() {
        Turn turn = new Turn();
        int[] array = new int[] {1, 2, 3, 4};
        int[] res = turn.turn(array);
        int[] expect = new int[] {4, 3, 2, 1};
        assertThat(res, is(expect));
    }

    @Test
    public void arrayTurn12345() {
        Turn turn = new Turn();
        int[] array = new int[] {1, 2, 3, 4, 5};
        int[] res = turn.turn(array);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(res, is(expect));
    }

    @Test
    public void arrayTurn12() {
        Turn turn = new Turn();
        int[] array = new int[] {1, 2};
        int[] res = turn.turn(array);
        int[] expect = new int[] {2, 1};
        assertThat(res, is(expect));
    }

    @Test
    public void arrayTurn1() {
        Turn turn = new Turn();
        int[] array = new int[] {1};
        int[] res = turn.turn(array);
        int[] expect = new int[] {1};
        assertThat(res, is(expect));
    }
}
