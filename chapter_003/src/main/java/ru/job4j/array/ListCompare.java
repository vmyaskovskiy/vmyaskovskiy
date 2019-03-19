package ru.job4j.array;

import java.util.Comparator;
/**
 * Class ListCompare решение задачи части 003 - 3. Компаратор для строк.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        for (int i = 0; i < o1.length(); i++) {
            int res = Character.compare(o1.charAt(i), o2.charAt(i));
            if (res != 0) {
                return res;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}


