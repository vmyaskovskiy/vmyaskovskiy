package ru.job4j.condition;
import static java.lang.Math.*;
/**
 * Class Point решение задачи части 001 - урок Расстояние между точками в системе координат 3.4.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;
    /**
     * конструктор для класса Point.
     * @param x входной параметр.
     * @param y входной параметр
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Method  distanceTo Вычисляет расстояние между точками.
     * @param b конечная точка.
     * @return расстояние.
     */
    public double distanceTo(Point b) {
        return sqrt(pow(b.x - this.x, 2) + pow(b.y - this.y, 2));
    }
}
