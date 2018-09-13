package ru.job4j.array;
/**
 * Class Check решение задачи части 001 - урок Массив заполнен true или false. 6.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Check {

    public boolean mono(boolean[] data) {
        int k = 0;
        int n = 0;
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == true ) {
                k++;
                if (k == data.length) {
                    result = true;
                } else {
                    result = false;
                }
            } else if (data[i] == false) {
                n++;
                if (n == data.length) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }return result;
    }
}
