package ru.job4j;

import org.junit.Test;
import ru.job4j.java2_0.task05.CalcMain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TestCalc тестирование задачи Калькулятор.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestCalc {
    @Test
    public void testSum() {
       CalcMain calcMain = new CalcMain();
       double res = 5.0;
       assertThat(calcMain.sum(2,3), is(res));
    }
    @Test
    public void testSub() {
        CalcMain calcMain = new CalcMain();
        double res = 5.0;
        assertThat(calcMain.sub(10,5), is(res));
    }
    @Test
    public void testMulti() {
        CalcMain calcMain = new CalcMain();
        double res = 5.0;
        assertThat(calcMain.mul(1,5), is(res));
    }
    @Test
    public void testDiv() {
        CalcMain calcMain = new CalcMain();
        double res = 3.5;
        assertThat(calcMain.div(7,2), is(res));
    }
    @Test
    public void testDivThenY0() {
        CalcMain calcMain = new CalcMain();
        double res = 0.0;
        assertThat(calcMain.div(10,0), is(res));
    }
}
