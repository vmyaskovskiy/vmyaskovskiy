package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */

public class Fit {

    /**
     * Идеальный вес для мужчины.
     * @param hight Рост.
     * @return идеальный вес.
     */
    public double manWaight(double hight) {

        return (hight - 100)*1.15;

    }
    /**
     * Идеальный вес для женщины.
     * @param hight Рост.
     * @return идеальный вес.
     */
     public double womanWaight(double hight) {

         return (hight - 110)*1.15;
     }
}
