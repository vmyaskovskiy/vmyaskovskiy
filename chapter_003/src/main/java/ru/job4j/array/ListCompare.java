package ru.job4j.array;

import java.util.Comparator;
/**
 * Class ListCompare решение задачи части 003 - 3. Компаратор для строк.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        int res = Integer.compare(o1.length(),o2.length());
        if (res == 0) {
            for (int i = 0; i < o1.length(); i++) {
                if (o1.charAt(i) == o2.charAt(i)) {
                }
                else return Character.compare(o1.charAt(i), o2.charAt(i)) > 0 ? 1 : -1;
            }return 0;
        } else if (res == 1) {
            for (int i = 0; i < o2.length(); i++) {
                if (o1.charAt(i) == o2.charAt(i)) {
                }
                else return Character.compare(o1.charAt(i), o2.charAt(i)) > 0 ? 1 : -1;
            }return 1;
        } else if (res == -1) {
            for (int i = 0; i < o1.length(); i++) {
                if (o1.charAt(i) == o2.charAt(i)) {
                }
                else return Character.compare(o1.charAt(i), o2.charAt(i)) > 0 ? 1 : -1;
            }return -1;
        }
        return 0;
    }
}
