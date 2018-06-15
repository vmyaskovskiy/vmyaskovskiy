package ru.job4j.prof;
/**
 * Class Diagnose решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Diagnose {
    private String nameIllness;

    public String getNameIllness() {
        return this.nameIllness;
    }
    /**
     * метод setNameIllness  устанавливает признак какая болезнь у пациента.
     */
    public void setNameIllness() {
        this.nameIllness = "Грипп";
    }
    /**
     * метод setNameNotIllness  устанавливает признак, что пациент здоров.
     */
    public void setNameNotIllness() {
        this.nameIllness = "Насморк";
    }
}
