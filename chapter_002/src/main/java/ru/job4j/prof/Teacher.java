package ru.job4j.prof;
/**
 * Class Teacher решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    public Teacher(String name, int age) {
        super(name, age);
    }
    /**
     * метод teaches вызывает метод setTrained установки признака, что студент сдал экзамен из класса Student.
     * @param  student входной параметр - студент.
     */
    public void teaches(Student student) {
        student.setTrained();
    }
}
