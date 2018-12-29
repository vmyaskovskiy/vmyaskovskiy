package ru.job4j.array;

import java.util.HashMap;
import java.util.List;
/**
 * Class UserConvert решение задачи части 003 - урок 2. Написать программу преобразования List в Map.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer,User> res = new HashMap<>();
        for(User user: list) {
            res.put(user.getId(), user);
        }
        return res;
    }
}
