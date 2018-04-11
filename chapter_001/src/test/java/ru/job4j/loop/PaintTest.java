package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class PaintTest тестирование задачи части 001 - урок Построить пирамиду в псевдографике 4.4.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class PaintTest {

    /**
     * Метод рисует пирамиду с высотой 3
     */
    @Test
    public void paintTestHeightThree() {
        Paint paint = new Paint();
        String res = paint.paint(3);
        String ln = System.lineSeparator();
        assertThat(res,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("  x  ")
                                .add(" xxx ")
                                .add("xxxxx")
                                .toString()
                )
        );
    }
    /**
     * Метод рисует пирамиду с высотой 4
     */
    @Test
    public void paintTestHeightFife() {
        Paint paint = new Paint();
        String res = paint.paint(4);
        String ln = System.lineSeparator();
        assertThat(res,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   x   ")
                                .add("  xxx  ")
                                .add(" xxxxx ")
                                .add("xxxxxxx")
                                .toString()
                )
        );
    }
    /**
     * Метод рисует пирамиду с высотой 1
     */
    @Test
    public void paintTestHeightOne() {
        Paint paint = new Paint();
        String res = paint.paint(1);
        String ln = System.lineSeparator();
        assertThat(res,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("x")
                                .toString()
                )
        );
    }
}
