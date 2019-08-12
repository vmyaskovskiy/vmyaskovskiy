package ru.job4j.array;

import java.util.ArrayList;
import java.util.List;
/**
 * Class PhoneDictionary решение задачи части 003 - урок Телефонный справочник.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionary {

    private List<Person> people = new ArrayList<Person>();

    public void add(Person person) {
        this.people.add(person);
    }
    public String getName(Person person) {
        var name = person.getName();
        return name;
    }
    public List<Person> find(String key) {
       List<Person> result = new ArrayList<>();
        for (var i = 0; i < this.people.size(); i++) {
            if (people.get(i).getName().contains(key)
                    || people.get(i).getSurname().contains(key)
                    || people.get(i).getAdress().contains(key)
                    || people.get(i).getPhone().contains(key)) {
                result.add(people.get(i));
            }
        }
       return result;
    }
}
