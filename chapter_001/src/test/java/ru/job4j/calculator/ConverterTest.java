package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(70);
        assertThat(result, is(1D));
    }
    @Test
    public void when60RubleToDollarsThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollars(60);
        assertThat(result, is(1D));
    }
    @Test
    public void when1DollarsToRubleThen60() {
        Converter converter = new Converter();
        double result = converter.dollarsToRuble(1);
        assertThat(result, is(60D));
    }
    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(1);
        assertThat(result, is(70D));
    }
}
