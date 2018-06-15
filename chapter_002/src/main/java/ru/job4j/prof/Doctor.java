package ru.job4j.prof;
/**
 * Class Doctor решение задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {

    public Doctor(String name, int age) {
        super(name, age);
    }
    /**
     * метод heal вызывает метод установки признака здоровья из класса Patient.
     * @param  patient входной параметр - пациент.
     */
    public void heal(Patient patient) {
        patient.setIll();
    }
    /**
     * метод diagnoseHeal анализирует симптом  из класса Patient и устанавливает имя болезни.
     * @param  patient входной параметр - пациент.
     * @param  diagnose входной параметр - диагноз.
     * @return возвращает имя болезни.
     */
    public String diagnoseHeal(Patient patient, Diagnose diagnose) {
        String simptone = patient.detSimpton();
        String nI = "Здоров";
        if (simptone == "Кашель") {
            diagnose.setNameIllness();
            String name = patient.getName();
            nI = diagnose.getNameIllness();
            return nI;
        } else if (simptone == "Насморк") {
            String name = patient.getName();
            diagnose.setNameNotIllness();
            nI = diagnose.getNameIllness();
            return nI;
        }
        return nI;
    }
}
