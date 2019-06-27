package ru.job4j.tracker;
import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;


import org.junit.Before;

public class StartUiTestRefThree {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.print(s);
        }
        @Override
        public String toString() {
            return new String(out.toByteArray());
        }
    };
    @Before
    public void loadOutput() {
        System.out.println("выполнять перед вызовом метода");
        System.setOut(new PrintStream(this.out));
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
    public void showAllItemOneTest() {
        TrackerTwo tracker = new TrackerTwo();
        Item item = new Item("d", "c");
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUiNewTwo(input, tracker, output).init();
        String expected = new StringBuilder()
                .append(this.menu)
                .append("------------ Найденные заявки --------------").append(ls)
                .append(item.getId() + ". d. c. " + item.getCreate() + "").append(ls)
                .append(this.menu)
                .append("------------ Выход из программы --------------").append(ls)
                .toString();

        assertThat(this.output.toString(), is(expected));
    }
    }

