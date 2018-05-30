package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestTwoArrayTest тестирование задачи части слить два не отсортированных массива и отсортировать.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestTwoArrayTest {
    @Test
    public void arrayMerge1203452To0122345() {
        TestTwoArray testTwoArray = new TestTwoArray();
        int[] left = new int[] {1, 2, 0};
        int[] right = new int[] {3, 4, 5, 2};
        int[] res = testTwoArray.merge(left, right);
        int[] expect = new int[] {0, 1, 2, 2, 3, 4, 5};
        assertThat(res, is(expect));
    }
    @Test
    public  void arrayMerge12345() {
        TestTwoArray testTwoArray = new TestTwoArray();
        int[] left = new int[] {1, 2};
        int[] right = new int[] {3, 4, 5};
        int[] res = testTwoArray.mergeTwo(left, right);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(res, is(expect));
    }
    @Test
    public  void arrayMerge34512() {
        TestTwoArray testTwoArray = new TestTwoArray();
        int[] left = new int[] {3, 4, 5};
        int[] right = new int[] {1, 2};
        int[] res = testTwoArray.mergeTwo(left, right);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(res, is(expect));
    }
    @Test
    public  void arrayMerge1432() {
        TestTwoArray testTwoArray = new TestTwoArray();
        int[] left = new int[] {1, 4};
        int[] right = new int[] {2, 3};
        int[] res = testTwoArray.mergeTwo(left, right);
        int[] expect = new int[] {1, 2, 3, 4};
        assertThat(res, is(expect));
    }
    @Test
    public  void arrayMerge3214() {
        TestTwoArray testTwoArray = new TestTwoArray();
        int[] left = new int[] {2, 3};
        int[] right = new int[] {1, 4};
        int[] res = testTwoArray.mergeTwo(left, right);
        int[] expect = new int[] {1, 2, 3, 4};
        assertThat(res, is(expect));
    }
    @Test
    public  void arrayMerge14523() {
        TestTwoArray testTwoArray = new TestTwoArray();
        int[] left = new int[] {1, 4, 5};
        int[] right = new int[] {2, 3};
        int[] res = testTwoArray.mergeTwo(left, right);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(res, is(expect));
    }
}
