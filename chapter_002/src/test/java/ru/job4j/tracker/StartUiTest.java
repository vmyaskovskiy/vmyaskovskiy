package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.StartUi;
import ru.job4j.tracker.start.StubInput;
import ru.job4j.tracker.start.Tracker;
import ru.job4j.tracker.start.Input;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
/**
 * Class StartUiTest тестирование задачи части 002 - ООП. тестирование класса StartUi.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class StartUiTest {
    @Test
    public void addItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test", "test", "1", "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test"));
    }
    @Test
    public void editItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[] {"2", item.getId(), "test", "test", "1", "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test"));
    }
    @Test
    public void showAllItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        Item itemTwo = new Item("f", "g");
        tracker.add(item);
        tracker.add(itemTwo);
        Input input = new StubInput(new String[] {"1",  "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("d"));
        assertThat(tracker.getAll()[1].getName(), is("f"));
        assertThat(tracker.getPosition(), is(2));
    }
    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[] {"3", item.getId(), "1", "6"});
        new StartUi(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }
    @Test
    public void findItemById() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("d"));
    }
    @Test
    public void findItemByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        Item itemOne = new Item("d", "g");
        Item itemTwo = new Item("v", "b");
        tracker.add(item);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        Input input = new StubInput(new String[]{"5", "d", "1", "6"});
        new StartUi(input, tracker).init();
        Item[] items = tracker.findByName("d");
        assertThat(items[0].getName(), is("d"));
        assertThat(items[1].getName(), is("d"));
        assertThat(tracker.getAll()[2].getName(), is("v"));
    }
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    String ls = System.lineSeparator();
    private StringBuilder menu = new StringBuilder()
            .append("0. Add the new item").append(ls)
            .append("1. Show all items").append(ls)
            .append("2. Edit items").append(ls)
            .append("3. Delete item").append(ls)
            .append("4. Find items by id").append(ls)
            .append("5. Find items by name").append(ls)
            .append("6. Exit").append(ls);
    @Test
    public void showAllItemOne() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUi(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                        .append(this.menu)
                        .append("------------ Найденные заявки --------------").append(ls)
                        .append(item.getId() + ". d. c. " + item.getCreate() + "").append(ls)
                        .append(this.menu)
                        .append("------------ Выход из программы --------------").append(ls)
                        .toString()
                )
        );
    }
    @Test
    public void findItemByIdOne() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUi(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                        .append(this.menu)
                        .append("------------ Поиск заявки --------------").append(System.lineSeparator())
                        .append("------------ Найденная заявка --------------").append(ls)
                        .append("Item{id='" + item.getId() + "', name='d', description='c', create=" + item.getCreate() + "}").append(System.lineSeparator())
                        .append(this.menu)
                        .append("------------ Выход из программы --------------").append(ls)
                        .toString()
                )
        );
    }
}
