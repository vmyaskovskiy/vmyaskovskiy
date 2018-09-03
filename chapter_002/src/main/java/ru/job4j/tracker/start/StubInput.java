package ru.job4j.tracker.start;
import java.util.*;
/**
 * Class StubInput решение задачи части 002 - урок Полиморфизм. Реализовать класс StubInput в классе StartUI .
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;

    public StubInput(final String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        return answers[position++];
    }
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("неподдержанная операция");
        return -1;
    }
}
