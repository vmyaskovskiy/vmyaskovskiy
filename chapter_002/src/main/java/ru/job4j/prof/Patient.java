package ru.job4j.prof;
/**
 * Class Patient решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Patient {
    private String name;
    private String ill;
    private String simpton;
    public Patient(String name, String simpton) {
        this.name = name;
        this.ill = "Болен";
        this.simpton = simpton;
    }
    public String getName() {
        return this.name;
    }
    public String getIll() {
        return this.ill;
    }
    /**
     * метод setIll  устанавливает признак , что пациент здоров.
     */
    public void setIll() {
        this.ill = "Здоров";
    }
    public  String detSimpton() {
        return this.simpton;
    }
}
