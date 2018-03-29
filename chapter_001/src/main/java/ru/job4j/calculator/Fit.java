package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */

public class Fit {
    private double manConst = 100;
    private double womanConst = 110;
    private double fixConst = 1.15;
    /**
     * Идеальный вес для мужчины.
     * @param hight Рост.
     * @return идеальный вес.
     */
    public double manWaight(double hight) {
        return (hight - manConst)*fixConst;
    }
    /**
     * Идеальный вес для женщины.
     * @param hight Рост.
     * @return идеальный вес.
     */
     public double womanWaight(double hight) {
         return (hight - womanConst)*fixConst;
     }
}
