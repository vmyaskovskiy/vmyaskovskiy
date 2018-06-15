package ru.job4j.prof;
/**
 * Class Engineer решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Engineer extends Profession {
    private String workName;
    public Engineer(String name, int age, String workName) {
        super(name, age);
        this.workName = workName;
    }
    /**
     * метод build вызывает метод установки признака постройки дома из класса House.
     * @param  house входной параметр - дом.
     */
    public void build(House house) {
        house.buildHouse();
    }
}
