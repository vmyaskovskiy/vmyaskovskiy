package ru.job4j.condition;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;
public class PointTest {
    @Test
    public void distanceTo() {
        Point pointA = new Point(0, 1);
        Point pointB = new Point(2, 5);
        double result = pointA.distanceTo(pointB);
        assertThat(result, Matchers.closeTo(4.47, 0.003));
    }
}
