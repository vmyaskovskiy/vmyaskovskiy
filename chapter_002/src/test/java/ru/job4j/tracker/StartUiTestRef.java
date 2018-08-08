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

public class StartUiTestRef {
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
    @Test
    public void showAllItemOne() {
        Tracker tracker = new Tracker();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUi(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                        .append("Меню.").append(System.lineSeparator())
                        .append("0. Add new Item").append(System.lineSeparator())
                        .append("1. Show all Item").append(System.lineSeparator())
                        .append("2. Edit Item").append(System.lineSeparator())
                        .append("3. Delete item").append(System.lineSeparator())
                        .append("4. Find item by Id").append(System.lineSeparator())
                        .append("5. Find items by name").append(System.lineSeparator())
                        .append("6. Exit Program").append(System.lineSeparator())
                        .append("Select:").append(System.lineSeparator())
                        .append("----------Показать все заявки---------").append(System.lineSeparator())
                        .append("----------Найденные заявки------------").append(System.lineSeparator())
                        .append("Id -- " + item.getId() + " ;  Имя -- d ;  Описание -- c ;  Data -- " + item.getCreate() + "").append(System.lineSeparator())
                        .append("Меню.").append(System.lineSeparator())
                        .append("0. Add new Item").append(System.lineSeparator())
                        .append("1. Show all Item").append(System.lineSeparator())
                        .append("2. Edit Item").append(System.lineSeparator())
                        .append("3. Delete item").append(System.lineSeparator())
                        .append("4. Find item by Id").append(System.lineSeparator())
                        .append("5. Find items by name").append(System.lineSeparator())
                        .append("6. Exit Program").append(System.lineSeparator())
                        .append("Select:").append(System.lineSeparator())
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
                        .append("Меню.").append(System.lineSeparator())
                        .append("0. Add new Item").append(System.lineSeparator())
                        .append("1. Show all Item").append(System.lineSeparator())
                        .append("2. Edit Item").append(System.lineSeparator())
                        .append("3. Delete item").append(System.lineSeparator())
                        .append("4. Find item by Id").append(System.lineSeparator())
                        .append("5. Find items by name").append(System.lineSeparator())
                        .append("6. Exit Program").append(System.lineSeparator())
                        .append("Select:").append(System.lineSeparator())
                        .append("---------Найти заявку по ID-------------").append(System.lineSeparator())
                        .append(" Найдена заявка--  Item{id='" + item.getId() + "', name='d', description='c', create=" + item.getCreate() + "}").append(System.lineSeparator())
                        .append("Меню.").append(System.lineSeparator())
                        .append("0. Add new Item").append(System.lineSeparator())
                        .append("1. Show all Item").append(System.lineSeparator())
                        .append("2. Edit Item").append(System.lineSeparator())
                        .append("3. Delete item").append(System.lineSeparator())
                        .append("4. Find item by Id").append(System.lineSeparator())
                        .append("5. Find items by name").append(System.lineSeparator())
                        .append("6. Exit Program").append(System.lineSeparator())
                        .append("Select:").append(System.lineSeparator())
                        .toString()
                )
        );
    }
}
