package ru.job4j;
import org.junit.Test;
import org.junit.Before;

import ru.job4j.lyambda.SimpleHashMap;
import ru.job4j.lyambda.UserMap;
import java.util.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserMapTest {
    SimpleHashMap<UserMap, Integer> map = new SimpleHashMap<>();
    Calendar calendar1 = new GregorianCalendar(2017, 0, 25);
    UserMap user1 = new UserMap("Slava", 2, calendar1);
    UserMap user2 = new UserMap("Slava", 2, calendar1);
    @Before
    public void beforeTest() {
        map.insert(user1, 1);
        map.insert(user2, 2);
    }
    @Test
    public void putTest() {
        assertThat(map.get(user1), is(2));
    }
}
