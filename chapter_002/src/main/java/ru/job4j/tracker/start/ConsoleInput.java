package ru.job4j.tracker.start;
import java.util.*;
/**
 * Class ConsoleInput решение задачи части 002 - урок Полиморфизм. Реализовать класс ConsoleInput в классе StartUI .
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public  String ask(String question) {
        System.out.print(question);
         return scanner.nextLine();
    }
}
