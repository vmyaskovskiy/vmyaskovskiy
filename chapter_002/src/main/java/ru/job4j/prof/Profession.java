package ru.job4j.prof;
/**
 * Class Profession решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Profession {
    private String name;
    private int age;
    private String profName;
    private String workName;
    public Profession(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * метод getName возвращает имя.
     * @return возвращает  имя .
     */
    public String getName() {
        return this.name;
    }
    public String getProfName() {
        return this.profName;
    }
}
