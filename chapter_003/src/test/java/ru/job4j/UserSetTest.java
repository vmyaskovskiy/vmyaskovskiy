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
        UserForSet user1 = new UserForSet("Boba", 3);
        UserForSet user2 = new UserForSet("Cet", 5);
        UserForSet user3 = new UserForSet("Cet", 2);
        UserForSet user4 = new UserForSet("Abbaa", 2);
        UserForSet user5 = new UserForSet("Abbaa", 1);
        res.addUserSet(user1);
        res.addUserSet(user2);
        res.addUserSet(user3);
        res.addUserSet(user4);
        res.addUserSet(user5);
        assertThat(res.sort(res.getUser()).iterator().next().getAge(), is(1));
        assertThat(res.sortName(res.getUser()).iterator().next().getName(), is("Cet"));
        assertThat(res.sotrByLenghtName(res.getUser()).iterator().next().getName(), is("Cet"));
        assertThat(res.sortByAllFields(res.getUser()).iterator().next().getAge(), is(1));
        assertThat(res.sortByAllFields(res.getUser()).iterator().next().getName(), is("Abbaa"));
        assertThat(res.sortByAllFieldsTwo(res.getUser()).iterator().next().getName(), is("Abbaa"));
    }
}
