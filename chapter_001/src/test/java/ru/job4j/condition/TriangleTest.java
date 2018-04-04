package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.hamcrest.Matchers;

/**
 * Class TriangleTest тест задачи части 001 - урок Вычисление площади треугольника 3.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {

    @Test
    public void  triangleTestNotExitPointOnLine() {
        Point pointA = new Point(0, 1);
        Point pointB = new Point(0, 4);
        Point pointC = new Point(0, 8);
        Triangle tri = new Triangle(pointA, pointB, pointC);
        assertThat(tri.area(), Matchers.closeTo(-1D, 0.1));

    }
    @Test
    public void  triangleTestExit() {
        Point pointA = new Point(0, 1);
        Point pointB = new Point(4, 4);
        Point pointC = new Point(1, 8);
        Triangle tri = new Triangle(pointA, pointB, pointC);
        assertThat(tri.area(), Matchers.closeTo(12.5D, 0.1));
    }

    @Test
    public void  triangleTestNotExitAllPointOnOnePoint() {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(1, 1);
        Point pointC = new Point(1, 1);
        Triangle tri = new Triangle(pointA, pointB, pointC);
        assertThat(tri.area(), Matchers.closeTo(-1D, 0.1));
    }

    @Test
    public void  triangleTestNotExitTwoPointOnOnePoint() {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(1, 1);
        Point pointC = new Point(5, 1);
        Triangle tri = new Triangle(pointA, pointB, pointC);
        assertThat(tri.area(), Matchers.closeTo(-1D, 0.1));
    }

    @Test
    public void  triangleTestExitPointTooClose() {
        Point pointA = new Point(1, 2);
        Point pointB = new Point(2, 1);
        Point pointC = new Point(1, 3);
        Triangle tri = new Triangle(pointA, pointB, pointC);
        assertThat(tri.area(), Matchers.closeTo(0.4D, 0.1));
    }

    @Test
    public void  triangleTestExitPointMinus() {
        Point pointA = new Point(-1, -2);
        Point pointB = new Point(2, 1);
        Point pointC = new Point(1, 3);
        Triangle tri = new Triangle(pointA, pointB, pointC);
        assertThat(tri.area(), Matchers.closeTo(4.5D, 0.1));
    }
}
