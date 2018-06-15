package ru.job4j.prof;
/**
 * Class Student решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Student {
    private String name;
    private String trained = "Не сдавал экзамен";
    public Student(String name) {
        this.name = name;
    }
    /**
     * метод setTrained  устанавливает признак , что студент сдал экзамен.
     */
    public void setTrained() {
        this.trained = "Сдал экзамен на 5";
    }
    public String getTrained() {
        return this.trained;
    }
    public String getName() {
        return this.name;
    }
}
