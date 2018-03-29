package ru.job4j.calculator;


import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FitTest {
    @Test

    public void manWaight() {
        Fit fit = new Fit();
        double waight = fit.manWaight(190D);
        assertThat(waight, Matchers.closeTo(103.5, 0.1));
    }

    @Test
    public void womanWaight() {
        Fit fit = new Fit();
        double waight = fit.womanWaight(170D);
        assertThat(waight, Matchers.closeTo(69.0, 0.1));
    }
}
