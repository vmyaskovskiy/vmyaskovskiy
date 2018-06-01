package ru.job4j.calculator;
/**
 * Конвертер валюты.
 */
public class Converter {
    private int euroConst = 70;
    private int dollarConst = 60;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / euroConst;
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Dollars.
     */
    public int rubleToDollars(int value) {
        return value / dollarConst;
    }
    /**
     * Конвертируем  доллары в рубли.
     * @param value Dollars.
     * @return рубли.
     */
     public int dollarsToRuble(int value) {
         return value * dollarConst;
     }
    /**
     * Конвертируем  евро в рубли.
     * @param value Euro.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * euroConst;
    }
}
