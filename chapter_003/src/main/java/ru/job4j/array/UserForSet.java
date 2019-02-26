package ru.job4j.array;
/**
 * Class UserForSet решение задачи части 003 - урок 3. Организовать сортировку User.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class UserForSet implements Comparable<UserForSet> {
    private String name;
    private int age;
    public UserForSet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public  int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
   @Override
    public int compareTo(UserForSet o) {
       return Integer.compare(this.getAge(), o.getAge());
    }
}
