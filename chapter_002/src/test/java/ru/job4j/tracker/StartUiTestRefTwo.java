package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;

public class StartUiTestRefTwo {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("выполнять перед вызовом метода");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("выполнять после вызова метода");
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
            //.append("Select").append(ls);
    @Test
    public void showAllItemOne() {
        SqlTracker tracker = new SqlTracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUiNewTwo(input, tracker, System.out::println).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                        .append(this.menu)
                        //.append("----------Показать все заявки---------").append(ls)
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
        SqlTracker tracker = new SqlTracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", String.valueOf(item.getId()), "6"});
        new StartUiNewTwo(input, tracker, System.out::println).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                        .append(this.menu)
                        .append("------------ Поиск заявки --------------").append(ls)
                        .append("------------ Найденная заявка --------------").append(ls)
                        .append("Item{id='" + item.getId() + "', name='d', description='c', create=" + item.getCreate() + "}").append(ls)
                        .append(this.menu)
                        .append("------------ Выход из программы --------------").append(ls)
                        .toString()
                )
        );
    }
}
