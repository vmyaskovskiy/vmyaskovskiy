package ru.job4j;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.lyambda.UserMap;
import java.util.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserMapTest {
    Map<UserMap, Integer> map = new HashMap<>();
    @Before
    public void beforeTest() {
        Calendar calendar1 = new GregorianCalendar(2017,0, 25);
        Calendar calendar2 = new GregorianCalendar(2016,1, 26);
        UserMap user1 = new UserMap("Slava", 2, calendar1);
        UserMap user2 = new UserMap("Slava", 2, calendar1);
        UserMap user3 = new UserMap("Vova", 2, calendar1);
        map.put(user1, 1);
        map.put(user2, 2);
        map.put(user3, 3);
    }
    @Test
    public void putTest() {
        assertThat(map.size(), is(2));
    }
}
