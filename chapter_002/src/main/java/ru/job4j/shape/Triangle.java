package ru.job4j.shape;
/**
 * Class Triangle решение задачи части 002 - урок 4.4 Полиморфизм. Использовать шаблон проектирования - стратегию.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +  ");
        pic.append(" + + ");
        pic.append("+++++");
        return pic.toString();
    }
}
