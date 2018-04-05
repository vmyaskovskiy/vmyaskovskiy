package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MaxTest тест задачи части 001 - урок Максимум из двух чисел 3.2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {

    @Test

    public void maxFromTwoNumberOneAndTwo() {
        Max max = new Max();
        int res = max.maxN(1, 2);
        assertThat(res, is(2));
    }

    @Test

    public void maxFromTwoNumberOneAndOne() {
        Max max = new Max();
        int res = max.maxN(1, 1);
        assertThat(res, is(1));
    }

    @Test

    public void maxFromTwoNumberZeroAndZero() {
        Max max = new Max();
        int res = max.maxN(0, 0);
        assertThat(res, is(0));
    }

    @Test

    public void maxFromTwoNumberMinusOneAndOne() {
        Max max = new Max();
        int res = max.maxN(-1, 0);
        assertThat(res, is(0));
    }

    @Test

    public void maxFromThreeNumberOneAndTwoAndThreeReturnThree() {
        Max max = new Max();
        int res = max.max(1, 2, 3);
        assertThat(res, is(3));
    }

    @Test

    public void maxFromThreeNumberThreeAndTwoAndOneReturnThree() {
        Max max = new Max();
        int res = max.max(3, 2, 1);
        assertThat(res, is(3));
    }

    @Test

    public void maxFromThreeNumberMinusThreeAndTwoAndOneReturnTwo() {
        Max max = new Max();
        int res = max.max(-3, 2, 1);
        assertThat(res, is(2));
    }
}
