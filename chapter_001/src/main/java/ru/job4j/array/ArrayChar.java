package ru.job4j.array;
/**
 * Class ArrayChar решение задачи части 001 - урок Слова начинается с ... 5.5.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
    private char[] date;
    public ArrayChar(String line) {
        this.date = line.toCharArray();
    }
    /**
     * метод startWith проверяет заданный префикс с словом на совпадение.
     * @param  prefix входной параметр - префикс.
     * @return возвращает  true если заданный префикс совпадает с префиксом в слове.
     */
    public boolean startWith(String prefix) {
        boolean res = true;
        char[] value = prefix.toCharArray();

        for (int i = 0; i < value.length; i++) {
            if (value[i] != this.date[i]) {
                res = false;
            }
        }
        return res;
    }
}
