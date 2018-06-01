package ru.job4j.loop;
/**
 * Class Paint решение задачи части 001 - урок Построить пирамиду в псевдографике. 4.4.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * метод paint рисует шахматную доску.
     * @param  height входной параметр высота пирамиды.
     * @return возвращает пирамиду в псевдографике.
     */
    public String paint(int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int row = 1; row <= height; row++) {
             for (int column = 1; column <= height + (height - 1); column++) {
                 if ((column < height - (row - 1)) || (column > height + (row - 1))) {
                     screen.append(" ");
                 } else {
                     screen.append("x");
                 }
             }
            screen.append(ln);
        }
        return screen.toString();
        }
    }