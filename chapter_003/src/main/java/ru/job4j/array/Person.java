package ru.job4j.array;
/**
 * Class Person решение задачи части 003 - урок Телефонный справочник.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String adress;

    public Person(String name, String surname, String phone, String adress) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhone() {
        return phone;
    }
    public String getAdress() {
        return adress;
    }
}
