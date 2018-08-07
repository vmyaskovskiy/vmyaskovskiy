package ru.job4j.shape;
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
    @Test
    public void testSquare() {
        Square square = new Square();
        StringBuilder picRes = new StringBuilder();
        picRes.append("++++");
        picRes.append("+  +");
        picRes.append("+  +");
        picRes.append("++++");
        assertThat(square.draw(), is(picRes.toString()));
    }
    @Test
    public void testTriangle() {
        Triangle triangle = new Triangle();
        StringBuilder picTriRes = new StringBuilder();
        picTriRes.append("  +  ");
        picTriRes.append(" + + ");
        picTriRes.append("+++++");
        assertThat(triangle.draw(), is(picTriRes.toString()));
    }
    @Test
    public void testPaintSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("++++")
                .append("+  +")
                .append("+  +")
                .append("++++")
                .append(System.lineSeparator())
                .toString()
        )
        );
        System.setOut(stdout);
    }
    @Test
    public void testPaintTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append("  +  ")
                        .append(" + + ")
                        .append("+++++")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
        System.setOut(stdout);
    }
}
