package ru.job4j.loop;
/**
 * Class Board решение задачи части 001 - урок Построить шахматную доску в псевдографике 4.3.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * метод paint рисует шахматную доску.
     * @param  width входной параметр ширина доски.
     * @param  height входной параметр высота доски.
     * @return возвращает доску в псевдографике.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                screen.append(" ");
                }
            }
               screen.append(ln);
            }
            return screen.toString();
        }
}
