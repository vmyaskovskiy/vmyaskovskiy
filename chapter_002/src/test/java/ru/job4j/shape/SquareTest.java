package ru.job4j.shape;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class SquareTest решение задачи части 002 - урок 4.4 Полиморфизм. Использовать шаблон проектирования - стратегию.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
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
    public void testPaintSquare() {
        new Paint().draw(new Square());
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                .append("++++")
                .append("+  +")
                .append("+  +")
                .append("++++")
                .append(System.lineSeparator())
                .toString()
        )
        );
    }
    @Test
    public void testPaintTriangle() {
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append("  +  ")
                        .append(" + + ")
                        .append("+++++")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }
}
