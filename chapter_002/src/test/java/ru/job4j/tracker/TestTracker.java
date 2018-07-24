package ru.job4j.tracker;
import org.junit.Test;
import ru.job4j.traсker.models.Item;
import ru.job4j.traсker.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestProf тестирование задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestTracker {
    @Test
    public void addNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("sekond", "desk2", 0102);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
        String resId = item.getId();
        assertThat(tracker.findById(resId).getName(), is("sekond"));
        Item[] resName = tracker.findByName("sekond");
        assertThat(resName[0].getName(), is("sekond"));
    }
    @Test
    public void replaceItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("первый", "desk2", 0102);
        tracker.add(previous);
        Item next = new Item("второй", "desk3", 0103);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("второй"));
    }
    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("sekond", "desk2", 0102);
        tracker.add(previous);
        Item next = new Item("therd", "desk3", 0103);
        tracker.add(next);
        Item nextNext = new Item("four", "desk4", 0104);
        tracker.add(nextNext);
        tracker.delete(next.getId());
        assertThat(tracker.findById(next.getId()), is(new Item()));
        assertThat(tracker.findById(nextNext.getId()).getName(), is("four"));
    }
    @Test
    public void deleteItemNext() {
        Tracker tracker = new Tracker();
        Item previous = new Item("sekond", "desk2", 0102);
        tracker.add(previous);
        Item next = new Item("therd", "desk3", 0103);
        tracker.add(next);
        Item nextNext = new Item("four", "desk4", 0104);
        tracker.add(nextNext);
        tracker.delete(nextNext.getId());
        assertThat(tracker.findById(nextNext.getId()), is(new Item()));
        assertThat(tracker.findById(previous.getId()).getName(), is("sekond"));
    }
    @Test
    public void deleteItemPrevious() {
        Tracker tracker = new Tracker();
        Item previous = new Item("sekond", "desk2", 0102);
        tracker.add(previous);
        Item next = new Item("therd", "desk3", 0103);
        tracker.add(next);
        Item nextNext = new Item("four", "desk4", 0104);
        tracker.add(nextNext);
        tracker.delete(previous.getId());
        assertThat(tracker.findById(previous.getId()), is(new Item()));
        assertThat(tracker.findById(next.getId()).getName(), is("therd"));
    }
    @Test
    public void getAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("первый", "desk1", 0101);
        Item item2 = new Item("первый", "desk2", 0102);
        tracker.add(item);
        tracker.add(item2);
        Item[] items = tracker.getAll();
        Item[] itemsCopy = tracker.getAll();
        Item[] itemCopies = new Item[2];
        itemCopies[0] = item;
        itemCopies[1] = item2;
        assertThat(items, is(itemsCopy));
        assertThat(itemCopies, is(items));
    }
    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("первый", "desk1", 0101);
        Item item2 = new Item("первый", "desk2", 0102);
        Item item3 = new Item("третий", "desk3", 0103);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] items = tracker.findByName("первый");
        assertThat(tracker.findById(items[0].getId()).getName(), is("первый"));
        assertThat(tracker.findById(items[0].getId()), is(tracker.findById(item.getId())));
        assertThat(tracker.findById(items[1].getId()), is(tracker.findById(item2.getId())));
    }
    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = new Item("первый", "desk1", 0101);
        tracker.add(item);
        String resId = item.getId();
        assertThat(tracker.findById(resId).getId(), is(resId));
        assertThat(tracker.findById(resId).getName(), is("первый"));
    }
}
