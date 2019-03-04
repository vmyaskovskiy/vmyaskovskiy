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
    public void addUserSet(UserForSet userForSet) {
        this.user.add(userForSet);
    }
    public List<UserForSet> getUser() {
        return this.user;
    }
     public Set<UserForSet> sort(List<UserForSet> o) {
        return new TreeSet<>(o);
     }

     public List<UserForSet> sortName(List<UserForSet> o) {
        class NameCompare implements Comparator<UserForSet> {
            public int compare(UserForSet one, UserForSet two) {
                return Integer.compare(one.getName().length(), two.getName().length());
            }
        }
        NameCompare res = new NameCompare();
                         Collections.sort(o, res);
               return o;
     }

     public List<UserForSet> sotrByLenghtName(List<UserForSet> o) {
         Collections.sort(o, new Comparator<UserForSet>() {
             @Override
             public int compare(UserForSet o1, UserForSet o2) {
                 return Integer.compare(o1.getName().length(), o2.getName().length());
             }
         });
         return o;
     }
     public List<UserForSet> sortByAllFields(List<UserForSet> o) {
        class AllFieldsCompare implements Comparator<UserForSet> {
            public int compare(UserForSet one, UserForSet two) {
               if (one.getName().equals(two.getName())) {
                   return one.compareTo(two);
               }
               return one.getName().compareTo(two.getName());
            }
        }
        AllFieldsCompare res = new AllFieldsCompare();
        Collections.sort(o, res);
        return o;
     }
    public List<UserForSet> sortByAllFieldsTwo(List<UserForSet> o) {

        Collections.sort(o, new Comparator<UserForSet>() {
            @Override
            public int compare(UserForSet o1, UserForSet o2) {
                if (o1.getName().equals(o2.getName())) {
                    return o1.compareTo(o2);
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        return o;
    }
}
