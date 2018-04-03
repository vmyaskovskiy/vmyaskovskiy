package ru.job4j.calculator;


import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FitTest {
    @Test

    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(190D);
        assertThat(weight, Matchers.closeTo(103.5, 0.1));
    }

    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double waight = fit.womanWeight(170D);
        assertThat(waight, Matchers.closeTo(69.0, 0.1));
    }
}
