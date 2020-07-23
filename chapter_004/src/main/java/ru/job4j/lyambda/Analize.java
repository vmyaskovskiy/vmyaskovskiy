package ru.job4j.lyambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Analize решение задачи  Статистика по коллекции.[#143698]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        List<User> pr = previous;
        List<User> cur = current;
        Info info = new Info();
        Map<Integer, User> mapPr = new HashMap<>();
        Map<Integer, User> mapCur = new HashMap<>();
        int c = cur.size();
        int p = pr.size();

        for (User user: pr) {
            mapPr.put(user.id, user);
        }
        for (User user: cur) {
            mapCur.put(user.id, user);
            if (!mapPr.containsValue(user)) {
                info.added++;
            } else if (!mapPr.get(user.id).name.equals(mapCur.get(user.id).name)) {
                info.changed++;
            }
        }
         if (p >= c) {
            info.deleted = p - c + info.added;
         }
        return info;
    }
    public static class User {
        int id;
        String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
        @Override
        public String toString() {
            return " id = " + this.id + ", name " + this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public int getAdded() {
            return added;
        }
        public int getChanged() {
            return changed;
        }
        public int getDeleted() {
            return deleted;
        }
    }
}

