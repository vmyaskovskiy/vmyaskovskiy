package ru.job4j.calculator;

/**
 * Конвертер валюты.
 */

public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {

        return value / 70;

    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Dollars.
     */

    public int rubleToDollars(int value) {

        return value / 60;

    }

    /**
     * Конвертируем  доллары в рубли.
     * @param value Dollars.
     * @return рубли.
     */

     public int dollarsToRuble(int value) {

         return value * 60;

     }

    /**
     * Конвертируем  евро в рубли.
     * @param value Euro.
     * @return рубли.
     */

    public int euroToRuble(int value) {

        return value * 70;

    }

}
