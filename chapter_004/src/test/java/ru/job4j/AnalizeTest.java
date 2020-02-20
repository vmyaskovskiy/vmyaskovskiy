package ru.job4j;
import org.junit.Test;
import ru.job4j.lyambda.Analize;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
/**
 * Class AnalizeTest тестирование задачи  Статистика по коллекции.[#143698]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class AnalizeTest {

    Analize analize = new Analize();
    Analize.User user1 = new Analize.User(1, "Slava");
    Analize.User user2 = new Analize.User(2, "Petr");
    Analize.User user3 = new Analize.User(2, "Fedor");
    Analize.User user4 = new Analize.User(3, "Dima");
    Analize.User user5 = new Analize.User(4, "Boris");
    Analize.User user6 = new Analize.User(5, "Boris");
    Analize.User user7 = new Analize.User(6, "Semen");
    List<Analize.User> listPr = new ArrayList<Analize.User>();
    List<Analize.User> listCur = new ArrayList<Analize.User>();

  // в начальном списке есть 1 объект, в конечном его нет, значит был удален 1 элемент
    @Test
    public void when1ElDelRes1() {
        listPr.add(user1);
        Analize.Info info = analize.diff(listPr,listCur);
        assertThat(info.getDeleted(), is(1));
        assertThat(info.getChanged(), is(0));
        assertThat(info.getAdded(), is(0));
    }
    // в начальном списке есть 1 объект, в конечном он есть, значит изменений в списках не было
    @Test
    public void when1ElAddAnd1ElLast() {
        listPr.add(user1);
        listCur.add(user1);
        Analize.Info info = analize.diff(listPr,listCur);
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getChanged(), is(0));
        assertThat(info.getAdded(), is(0));
    }

    // в начальном списке есть 1 объект, в конечном он есть, но имя изменено, значит изменений в списках 1
    // изменений в списках:
    // Изменен 1 объект
    @Test
    public void when1ElAddAnd1ElChang() {
        listPr.add(user2);
        listCur.add(user3);
        Analize.Info info = analize.diff(listPr,listCur);
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getAdded(), is(0));
    }

    // в начальном списке есть 1 объект, в конечном добавили еще один, у одного  имя изменено,
    // изменений в списках:
    // Изменен 1 объект
    // Добавлен 1 объект
    @Test
    public void when2ElAddAnd1ElChang() {
        listCur.add(user4);
        listPr.add(user2);
        listCur.add(user3);
        Analize.Info info = analize.diff(listPr,listCur);
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getAdded(), is(1));
    }

    // в начальном списке есть 1 объект, в конечном добавили еще один, у одного  имя изменено, один удален
    // изменений в списках:
    // Изменен 1 объект
    // Добавлен 1 объект
    // Удален 1 объект
    @Test
    public void when2ElAddAnd1ElChangAnd4ElDell() {
        listPr.add(user1);
        listCur.add(user4);
        listPr.add(user2);
        listCur.add(user3);
        Analize.Info info = analize.diff(listPr,listCur);
        assertThat(info.getDeleted(), is(1));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getAdded(), is(1));
    }

    // изменений в списках:
    // Изменен 1 объект
    // Добавлен 1 объект
    // Удалено 4 объекта
    @Test
    public void when2ElAddAnd1ElChangAnd3ElDell() {
        listPr.add(user1);listCur.add(user4);
        listPr.add(user2); listCur.add(user3);
        listPr.add(user5);
        listPr.add(user6);
        listPr.add(user7);
        Analize.Info info = analize.diff(listPr,listCur);
        assertThat(info.getDeleted(), is(4));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getAdded(), is(1));
    }

}
