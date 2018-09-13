package ru.job4j.array;
/**
 * Class Check решение задачи части 001 - урок Массив заполнен true или false. 6.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Check {

    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean r;
        for (int i = 0; i < data.length - 1; i++) {
            r = data[i];
             if (r != data[i + 1]) {
                 result = false;
                 break;
             }
            result = true;
        } return result;
    }
}
