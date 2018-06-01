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
     * @param high Рост.
     * @return идеальный вес.
     */
    public double manWeight(double high) {
        return (high - manConst) * fixConst;
    }
    /**
     * Идеальный вес для женщины.
     * @param high Рост.
     * @return идеальный вес.
     */
     public double womanWeight(double high) {
         return (high - womanConst) * fixConst;
     }
}
