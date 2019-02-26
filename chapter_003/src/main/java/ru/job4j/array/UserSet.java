package ru.job4j.array;

import java.util.*;
/**
 * Class UserSet решение задачи части 003 - урок 3. Организовать сортировку User.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class UserSet  {
    private List<UserForSet> user = new ArrayList<>();
    public void addUserSet (UserForSet userForSet) {
        this.user.add(userForSet);
    }
    public List<UserForSet> getUser() {
        return this.user;
    }
     public Set<UserForSet> sort (List<UserForSet> o) {
        return new TreeSet<>(o);
     }
}
