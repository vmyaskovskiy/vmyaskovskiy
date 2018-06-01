package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class BoardTest решение задачи части 001 - урок Построить шахматную доску в псевдографике 4.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {
    @Test
    public void boardTestThreeOnThree() {
        Board board = new Board();
        String res = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(res, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
            )
        );
    }
    @Test
    public void boardTestOneOnOne() {
        Board board = new Board();
        String res = board.paint(1, 1);
        String ln = System.lineSeparator();
        assertThat(res, is(
                String.format("X%s", ln)
                )
        );
    }
    @Test
    public void boardTestFifeOneFour() {
        Board board = new Board();
        String res = board.paint(5, 4);
        String ln = System.lineSeparator();
        assertThat(res, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln)
                )
        );
    }
}
