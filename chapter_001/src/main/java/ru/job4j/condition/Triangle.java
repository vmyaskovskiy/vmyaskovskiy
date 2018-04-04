package ru.job4j.condition;

/**
 * Class Triangle решение задачи части 001 - урок Вычисление площади треугольника 3.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * конструктор Triangle для класса Point.
     * @param a входной параметр.
     * @param b входной параметр.
     * @param c входной параметр.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод area() - вычисляет площадь треугольника по формуле Герона, если заданы координаты трех точек.
     * @return res  возвращает площадь треугольника если он существует, -1 если треугольник не существует.
     */
    public double area() {
        double res = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double res1 = (ab + bc + ac) / 2;
        double res2 = Math.sqrt(res1 * (res1 - ab) * (res1 - ac) * (res1 - bc));
        if (res2 != 0) {
             res = res2;
        }
        return res;
    }
}
