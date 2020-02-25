package ru.job4j;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.lyambda.SimpleEntry;
import ru.job4j.lyambda.SimpleHashMap;
import ru.job4j.lyambda.UserMap;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleHashMapTest тесты к задачи 8. Реализовать собственную структуру данных - HashMap[#143718]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class SimpleHashMapTest {
    SimpleHashMap<UserMap, String> map = new SimpleHashMap<>();
    Calendar calendar1 = new GregorianCalendar(2017, 0, 25);
    Calendar calendar2 = new GregorianCalendar(2017, 0, 25);
    Calendar calendar3 = new GregorianCalendar(2017, 0, 25);
    Calendar calendar4 = new GregorianCalendar(2017, 0, 25);
    UserMap user1 = new UserMap("Slava", 2, calendar1);
    UserMap user2 = new UserMap("Petr", 2, calendar2);
    UserMap user3 = new UserMap("Вова", 2, calendar3);
    UserMap user4 = new UserMap("Саша", 2, calendar4);

    @Before
    public void beforeTest() {
        map.insert(user1, "первое значение");
        map.insert(user2, "второе значение");
        map.insert(user3, "третье значение");
        map.insert(user4, "четвертое значение");
    }

    @Test
    public void whenAddFourElementsThenUseGetAllResultGetAll() {
        assertThat(map.get(user1), is("первое значение"));
        assertThat(map.get(user2), is("второе значение"));
        assertThat(map.get(user3), is("третье значение"));
        assertThat(map.get(user4), is("четвертое значение"));
    }

    @Test
    public void nextAndHasNextCapacity12Index1and3and10and9() {

        Iterator<SimpleEntry> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("первое значение"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("второе значение"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("четвертое значение"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("третье значение"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void delOneIndex1() {
        assertThat(map.delete(user1), is(true));
        assertThat(map.get(user1), is((SimpleEntry) null));
    }

    @Test
    public void delOneIndexNo() {
        assertThat(map.delete(user1), is(true));
        assertThat(map.get(user1), is((SimpleEntry) null));
        assertThat(map.delete(user1), is(false));
    }




    @Test
    public void whenAdd5ElementsTheSame1() {
        map.insert(user1, "одинаковый ключ значение должен перезатереть старое value");
        assertThat(map.get(user1), is("одинаковый ключ значение должен перезатереть старое value"));
    }

    @Test
    public void whenAdd6ElementsTheSame1() {
        assertThat(map.get(user1), is("первое значение"));
        UserMap user1 = new UserMap("Boris", 3, calendar1);
        map.insert(user1, "новый объект Борис");
        assertThat(map.get(user1), is("новый объект Борис"));
        UserMap user6 = new UserMap("Boris", 3, calendar1);
        map.insert(user6, "разные ссылки на объект , объект одинаковый Борис, значение перетрется");
        assertThat(map.get(user6), is("разные ссылки на объект , объект одинаковый Борис, значение перетрется"));
        assertThat(map.get(user1), is("разные ссылки на объект , объект одинаковый Борис, значение перетрется"));
    }
    @Test
    public void when() {
        SimpleHashMap<String, String> mapNew = new SimpleHashMap<>();
        mapNew.insert("Vova", "Slava");
        assertThat(mapNew.get("Vova"), is("Slava"));
        mapNew.insert("Vova", "Vova");
        assertThat(mapNew.get("Vova"), is("Vova"));

    }
    @Test
    public void whenItter() {
        UserMap user8 = new UserMap("Viva", 2, calendar1);
        UserMap user9 = new UserMap("Pivo", 2, calendar2);
        map.insert(user8, "8 элемент");
        map.insert(user9, "9 элемент");
        Iterator<SimpleEntry> it = map.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getValue());
        }
    }

}
