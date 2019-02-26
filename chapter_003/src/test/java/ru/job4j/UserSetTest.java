package ru.job4j;
import org.junit.Test;
import ru.job4j.array.UserForSet;
import ru.job4j.array.UserSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class UserSetTest тестирование задачи части 003 - урок 3. Организовать сортировку User.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class UserSetTest {
    @Test
    public void testSet() {
        UserSet res = new UserSet();
        UserForSet user1 = new UserForSet("Bob", 3);
        UserForSet user2 = new UserForSet("Cet", 1);
        UserForSet user3 = new UserForSet("Cet", 2);
        UserForSet user4 = new UserForSet("Abba", 1);
        res.addUserSet(user1);
        res.addUserSet(user2);
        res.addUserSet(user3);
        res.addUserSet(user4);
        assertThat(res.sort(res.getUser()).iterator().next().getAge(), is(1));
        assertThat(res.getUser().iterator().next().getAge(), is(3));
       // assertThat(res.sort(res.getUser()).iterator().next().getName(), is("Abba"));
    }
}
