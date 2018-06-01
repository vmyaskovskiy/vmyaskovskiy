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
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * если сумма двух сторон равна третьей, то все точки лежат на одной линии.
     * если две или три координаты лежат в одной точке, то длинна одной или всех сторон равна 0.
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return true если треугольник существует, false  если нет.
     */
    private boolean exist(double ab, double ac, double bc) {
       boolean res = true;
        if (ab + bc == ac) {
          res = false;
        } else if (ab * bc * ac  == 0) {
            res = false;
        }
        return res;
    }
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
        if (this.exist(ab, ac, bc)) {
            double res1 = (ab + bc + ac) / 2;
             res = Math.sqrt(res1 * (res1 - ab) * (res1 - ac) * (res1 - bc));
        }
        return res;
    }
}
