package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TurnTest тестирование тестовой дополнительной задачи части 001.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestArrayTest {
    @Test
    public void arrayTurn1234() {
        TestArray testArray = new TestArray();
        int[] array = new int[]{1, 2, 3, 4};
        boolean res = testArray.arrayTestUp(array);
        boolean expect = true;
        assertThat(res, is(expect));
    }
    @Test
    public void arrayTurn4321() {
        TestArray testArray = new TestArray();
        int[] array = new int[]{4, 3, 2, 1};
        boolean res = testArray.arrayTestDown(array);
        boolean expect = true;
        assertThat(res, is(expect));
    }
    @Test
    public void arrayTurn4231Up() {
        TestArray testArray = new TestArray();
        int[] array = new int[]{4, 2, 3, 1};
        boolean res = testArray.arrayTestUp(array);
        boolean expect = false;
        assertThat(res, is(expect));
    }
    @Test
    public void arrayTurn4231Doun() {
        TestArray testArray = new TestArray();
        int[] array = new int[]{4, 2, 3, 1};
        boolean res = testArray.arrayTestDown(array);
        boolean expect = false;
        assertThat(res, is(expect));
    }
    @Test
    public void arrayTurn4221Doun() {
        TestArray testArray = new TestArray();
        int[] array = new int[]{4, 2, 2, 1};
        boolean res = testArray.arrayTestDown(array);
        boolean expect = false;
        assertThat(res, is(expect));
    }
}