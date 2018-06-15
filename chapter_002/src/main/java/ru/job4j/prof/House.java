package ru.job4j.prof;
/**
 * Class House решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class House {
    private String nameHouse;
    private String build;
    public House(String nameHouse) {
        this.nameHouse = nameHouse;
    }
    public String getNameHouse() {
        return this.nameHouse;
    }
    public String getBuild() {
        return this.build;
    }
    /**
     * метод buildHouse  устанавливает признак , что дом построен.
     */
    public void buildHouse() {
        this.build = "Построен";
    }
}
