package ru.job4j.shape;
/**
 * Class Paint решение задачи части 002 - урок 4.4 Полиморфизм. Использовать шаблон проектирования - стратегию.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
