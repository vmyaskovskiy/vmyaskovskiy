package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ArrayDuplicateTest тестирование задачи части 001 - урок Удаление дубликатов в массиве. 5.5.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[] {"Мир", "Труд", "Май"};
        String[] expected = new String[] {"Мир", "Труд", "Май"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithOneDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[]{"Привет", "Мир", "Мир"};
        String[] expected = new String[]{"Привет", "Мир"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithTwoDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = new String[] {"Привет", "Мир", "Супер"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithAllDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[] {"Мир", "Мир", "Мир", "Мир", "Мир"};
        String[] expected = new String[] {"Мир"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithAllDuplicateAndInTheMedleNo() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[] {"Мир", "Мир", "Привет", "Мир", "Мир"};
        String[] expected = new String[] {"Мир", "Привет"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithOne() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[] {"Мир"};
        String[] expected = new String[] {"Мир"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
    @Test
    public void whenRemoveDuplicatesThenArrayWithOneOneTwoTwo() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[] {"Мир", "Мир", "Труд", "Труд"};
        String[] expected = new String[] {"Мир", "Труд"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
}
