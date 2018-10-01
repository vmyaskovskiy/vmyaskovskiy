package ru.job4j.array;
import org.junit.Test;
import ru.job4j.tictactoe.Figure3T;
import ru.job4j.tictactoe.Logic3T;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class Logic3TTest тестирование задачи части 001 - урок Крестики-нолики на JavaFX, отвечает за проверку логики.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Logic3TTest {
   @Test
    public void whenHasXWinnerOne() {
       Figure3T[][] table = new Figure3T[][] {
               {new Figure3T(true), new Figure3T(), new Figure3T()},
               {new Figure3T(), new Figure3T(true), new Figure3T()},
               {new Figure3T(), new Figure3T(), new Figure3T(true)},
       };
       Logic3T logic = new Logic3T(table);
       assertThat(logic.isWinnerX(), is(true));
   }
    @Test
    public void whenHasXWinnerTwo() {
        Figure3T[][] table = new Figure3T[][] {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(true), new Figure3T(true), new Figure3T()},
                {new Figure3T(true), new Figure3T(), new Figure3T(false)},
        };
        Logic3T logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }
    @Test
    public void whenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(), new Figure3T()},
                {new Figure3T(false), new Figure3T(true), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }
    @Test
    public void whenHasOWinnerTwo() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T()},
                {new Figure3T(false), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }
    @Test
    public void whenHasGas() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }
    @Test
    public void whenHasGasTwo() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(false)},
                {new Figure3T(true), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(false));
    }
}
