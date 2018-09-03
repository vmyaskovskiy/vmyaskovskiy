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

/**
 * Class StartUiTest тестирование задачи части 002 - урок 4. Полиморфизм.
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
}




