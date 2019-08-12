package ru.job4j;
import org.junit.Test;
import ru.job4j.array.Person;
import ru.job4j.array.PhoneDictionary;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PhoneDictionaryTest тестирование задачи части 003 - урок Телефонный справочник.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionaryTest {

    @Test
    public void trueNameOne() {
        PhoneDictionary phone = new PhoneDictionary();
        var person = new Person("Slava", "Myas", "37", "vol1");
        var person1 = new Person("Ivan", "Petrov", "55", "vol2");
        phone.add(person);
        phone.add(person1);
        var personList = phone.find("Slava");
        assertThat(personList.iterator().next().getName(), is("Slava"));
    }
    @Test
    public void trueNameTwo() {
        PhoneDictionary phone = new PhoneDictionary();
        var person = new Person("Slava", "Myas", "37", "vol1");
        var person1 = new Person("Ivan", "Petrov", "55", "vol2");
        phone.add(person);
        phone.add(person1);
        var personList = phone.find("Ivan");
        assertThat(personList.iterator().next().getName(), is("Ivan"));
    }
    @Test
    public void trueSurNameOne() {
        PhoneDictionary phone = new PhoneDictionary();
        var person = new Person("Slava", "Myas", "37", "vol1");
        var person1 = new Person("Ivan", "Petrov", "55", "vol2");
        phone.add(person);
        phone.add(person1);
        var personList = phone.find("Myas");
        assertThat(personList.iterator().next().getSurname(), is("Myas"));
    }
    @Test
    public void truePhoneOnePart() {
        PhoneDictionary phone = new PhoneDictionary();
        var person = new Person("Slava", "Myas", "37", "vol1");
        var person1 = new Person("Ivan", "Petrov", "55", "vol2");
        phone.add(person);
        phone.add(person1);
        var personList = phone.find("5");
        assertThat(personList.iterator().next().getPhone(), is("55"));
    }
    @Test
    public void trueAdressTwoPart() {
        PhoneDictionary phone = new PhoneDictionary();
        var person = new Person("Slava", "Myas", "37", "vol1");
        var person1 = new Person("Ivan", "Petrov", "55", "vol2");
        phone.add(person);
        phone.add(person1);
        var personList = phone.find("1");
        assertThat(personList.iterator().next().getAdress(), is("vol1"));
    }
    @Test
    public void trueAdressTwoPartTheSame() {
        PhoneDictionary phone = new PhoneDictionary();
        var person = new Person("Slava", "Myas", "37", "vol1");
        var person1 = new Person("Ivan", "Petrov", "55", "vol2");
        phone.add(person);
        phone.add(person1);
        int size = phone.find("vol").size();
        assertThat(size, is(2));
    }
}
