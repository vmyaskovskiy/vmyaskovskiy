package ru.job4j.prof;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestProf тестирование задачи части 002 - урок 2. Наследование.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TestProf {
    @Test
    public void doctor() {
        Doctor doctor = new Doctor("Jon", 22);
        assertThat(doctor.getName(), is("Jon"));
    }
    @Test
    public void heal() {
        Doctor doctor = new Doctor("Jon", 22);
        Patient patient = new Patient("Abram", "Кашель");
        doctor.heal(patient);
        assertThat(patient.getIll(), is("Здоров"));
    }
    @Test
    public void patientGetName() {
        Patient patient = new Patient("Abram", "Кашель");
        assertThat(patient.getName(), is("Abram"));
    }
    @Test
    public void patientGetSimpton() {
        Patient patient = new Patient("Abram", "Кашель");
        assertThat(patient.detSimpton(), is("Кашель"));
    }
    @Test
    public void patientGetIll() {
        Patient patient = new Patient("Abram", "Кашель");
        assertThat(patient.getIll(), is("Болен"));
    }
    @Test
    public void patientSetIll() {
        Patient patient = new Patient("Abram", "Кашель");
        patient.setIll();
        assertThat(patient.getIll(), is("Здоров"));
    }
    @Test
    public void diagnoseHealGr() {
        Doctor doctor = new Doctor("Jon", 22);
        Patient patient = new Patient("Abram", "Кашель");
        Diagnose diagnose = new Diagnose();
        doctor.diagnoseHeal(patient, diagnose);
        assertThat(diagnose.getNameIllness(), is("Грипп"));
    }
    @Test
    public void diagnoseGetNameIllness() {
        Diagnose diagnose = new Diagnose();
        diagnose.setNameIllness();
        assertThat(diagnose.getNameIllness(), is("Грипп"));
    }
    @Test
    public void diagnoseGetNameNotIllness() {
        Diagnose diagnose = new Diagnose();
        diagnose.setNameNotIllness();
        assertThat(diagnose.getNameIllness(), is("Насморк"));
    }
    @Test
    public void diagnoseHealNotGr() {
        Doctor doctor = new Doctor("Jon", 22);
        Patient patient = new Patient("Abram", "Насморк");
        Diagnose diagnose = new Diagnose();
        doctor.diagnoseHeal(patient, diagnose);
        assertThat(diagnose.getNameIllness(), is("Насморк"));
    }
    @Test
    public void engineerGetName() {
        Engineer engineer = new Engineer("Jon", 22, "СтрйИнвест");
        assertThat(engineer.getName(), is("Jon"));
    }
    @Test
    public void engineerBuildHouse() {
        Engineer engineer = new Engineer("Jon", 22, "СтрйИнвест");
        House house = new House("СуперДом");
        engineer.build(house);
        assertThat(house.getBuild(), is("Построен"));
    }
    @Test
    public void houseGetName() {
        House house = new House("СуперДом");
        assertThat(house.getNameHouse(), is("СуперДом"));
    }
    @Test
    public void houseGetBuild() {
        House house = new House("СуперДом");
        house.buildHouse();
        assertThat(house.getBuild(), is("Построен"));
    }
    @Test
    public void teacherGetName() {
        Teacher teacher = new Teacher("Jon", 22);
        assertThat(teacher.getName(), is("Jon"));
    }
    @Test
    public void teacherTeaches() {
        Teacher teacher = new Teacher("Jon", 22);
        Student student = new Student("Abram");
        teacher.teaches(student);
        assertThat(student.getTrained(), is("Сдал экзамен на 5"));
    }
    @Test
    public void studentSetTrained() {
        Student student = new Student("Abram");
        student.setTrained();
        assertThat(student.getTrained(), is("Сдал экзамен на 5"));
    }
    @Test
    public void studentGetTrained() {
        Student student = new Student("Abram");
        assertThat(student.getTrained(), is("Не сдавал экзамен"));
    }
    @Test
    public void studentGetNeme() {
        Student student = new Student("Abram");
        assertThat(student.getName(), is("Abram"));
    }
}
