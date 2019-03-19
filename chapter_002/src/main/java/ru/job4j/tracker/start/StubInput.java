package ru.job4j.tracker.start;

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
    public Integer ask(String question) {
        return Integer.parseInt(answers[position++]);
    }

    @Override
    public String askTwo(String question) {
        return answers[position++];
    }

    public int ask(String question, int[] range) {
        return this.ask(question);
    }
    public int  askTwo(String question, int[] range) {
        return Integer.parseInt(this.askTwo(question));
    }
}
