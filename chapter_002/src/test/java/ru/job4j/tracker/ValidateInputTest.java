package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.start.ValidateInput;
import ru.job4j.tracker.start.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ValidateInputTest {
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream stdout = new ByteArrayOutputStream();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.stdout));
    }
    @After
    public void loadSys() {
        System.setOut(this.out);
    }
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"ты кто", "1"}));
        input.ask("ты кто", new int[] {1});
        assertThat(this.stdout.toString(), is(String.format("введите корректные данные%n"))
        );
    }

}
