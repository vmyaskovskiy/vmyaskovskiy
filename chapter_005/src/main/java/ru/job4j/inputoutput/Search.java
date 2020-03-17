package ru.job4j.inputoutput;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;
/**
 * Class Search решение задачи  3. Сканирование файловой системы.[#143741]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Search {

    public List<File> files(String parent, Predicate<String> condition) {
        File file = new File(parent);
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.add(file);

        while (!data.isEmpty()) {
            String str = data.poll().getPath();
            File fileOne = new File(str);
            for (File el: fileOne.listFiles()) {
                if (el.isDirectory()) {
                        data.add(el);
                } else if (condition.test(el.getName())) {
                    result.add(el);
                }
            }
        }
        return result;
    };
}
