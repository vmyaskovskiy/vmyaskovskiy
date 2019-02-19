package ru.job4j.tracker;
import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.TrackerTwo;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestTracker тестирование задачи части 002 - урок 3. тестирование класса Tracker.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestTrackerTwo {

    @Test
    public void addNewItemTwo() {
        TrackerTwo trackerTwo = new TrackerTwo();
        Item item = new Item("sekond", "desk2");
        trackerTwo.add(item);
        assertThat(trackerTwo.getAll().iterator().next().getName(), is("sekond"));
        assertThat(trackerTwo.getAll().iterator().next().getId(), is(item.getId()));
    }
    @Test
    public void replaceItemTwo() {
        TrackerTwo trackerTwo = new TrackerTwo();
        Item item = new Item("sekond", "desk2");
        Item itemOne = new Item("Bob", "desk3");
        Item itemTwo = new Item("Roy", "desk3");
        trackerTwo.add(item);
        trackerTwo.add(itemOne);
        trackerTwo.replace(item.getId(), itemTwo);
        assertThat(item.getName(), is("Roy"));
    }
    @Test
    public void dellItemTwo() {
        TrackerTwo trackerTwo = new TrackerTwo();
        Item item = new Item("sekond", "desk2");
        Item itemOne = new Item("Bob", "desk3");
        trackerTwo.add(item);
        trackerTwo.add(itemOne);
        assertThat(trackerTwo.getAll().size(), is(2));
        trackerTwo.delete(item.getId());
        assertThat(trackerTwo.getAll().size(), is(1));
        assertThat(trackerTwo.getAll().iterator().next().getName(), is("Bob"));
    }
    @Test
    public void findByNameItem() {
        TrackerTwo trackerTwo = new TrackerTwo();
        Item item = new Item("sekond", "desk2");
        Item itemOne = new Item("Bob", "desk3");
        Item itemTwo = new Item("Bob", "desk4");
        trackerTwo.add(item);
        trackerTwo.add(itemOne);
        trackerTwo.add(itemTwo);
        List<Item> res = trackerTwo.findByName("Bob");
        assertThat(res.size(), is(2));
        assertThat(res.get(0).getName(), is("Bob"));
    }
    @Test
    public void findByIdItem() {
        TrackerTwo trackerTwo = new TrackerTwo();
        Item item = new Item("sekond", "desk2");
        Item itemOne = new Item("Bob", "desk3");
        Item itemTwo = new Item("Bob", "desk4");
        trackerTwo.add(item);
        trackerTwo.add(itemOne);
        trackerTwo.add(itemTwo);
        Item res = trackerTwo.findById(item.getId());
        assertThat(res.getId(), is(item.getId()));
        assertThat(trackerTwo.getAll().iterator().next().getId(), is(item.getId()));
    }
}
