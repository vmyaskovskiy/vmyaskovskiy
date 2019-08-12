package ru.job4j;
import org.junit.Test;
import ru.job4j.array.User;
import ru.job4j.array.UserConvert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
/**
 * Class UserConvertTest тестирование задачи части 003 - урок 2. Написать программу преобразования List в Map.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {
    @Test
    public void list2Map() {
        UserConvert res = new UserConvert();
        List<User> resU = List.of(
                new User(1, "Petr", "Moscow"),
                new User(2, "Slava", "Kaluga"));
        assertThat(res.process(resU).get(1).getName(), is("Petr"));
        assertThat(res.process(resU).containsKey(2), is(true));
        assertThat(res.process(resU).containsKey(3), is(false));
    }
}
