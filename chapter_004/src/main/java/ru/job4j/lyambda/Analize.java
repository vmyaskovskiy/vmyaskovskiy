package ru.job4j.lyambda;

import java.util.List;
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
        int c = cur.size();
        int p = pr.size();
        for(int i = 0; i < p; i++) {
            User userPr = pr.get(i);
            if(cur.contains(userPr)) {
                for (int j = 0; j < c; j++) {
                    if(cur.get(j).equals(userPr)) {
                        User userCur = cur.get(j);
                        if(!userPr.name.equals(userCur.name)) {
                            info.changed++;
                        }
                    }
                }
            } else {
                info.deleted++;
            }
        }
        for(int i = 0; i < c; i++) {
            if(!pr.contains(cur.get(i))) {
                info.added++;
            }
        }
        return info;
    }
    public static class User {
        int id;
        String name;
        public User (int id, String name) {
            this.id = id;
            this.name = name;
        }
        @Override
        public String toString() {
            return " id = " + this.id + ", name " + this.name  ;
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

