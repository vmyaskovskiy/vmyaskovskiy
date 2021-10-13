package ru.job4j.java20.task06;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;
/**
 * Class TestWord решение задачи 6 - считывание и анализ данных из файла.
 * Есть входной файл с набором слов, написанных через пробел
 * @author myaskovskiy_vv
 */
public class TestWord {
    /**
     * метод для чтения из файла
     */
    public String[] listWord(String path) throws IOException {
        try (FileInputStream in = new FileInputStream(path)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(" ");
            return lines;
        }
    }

    public static void main(String[] args) throws IOException {

        TestWord testWord = new TestWord();
        // прочитаем файл
        String[] strW = testWord.listWord("C:/задача6.txt");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        // запишем в MAP пары ключ значение - слово : количество повторений
        // затем избавимся от дубликатов , записав в SET
        for (String str: strW) {
            String tempStr = str;
            if (!map.containsKey(tempStr)) {
                map.put(tempStr, 1);
            } else {
                map.put(tempStr, map.get(tempStr) + 1);
            }
            set.add(str);
        }
        // найдем слово с максимальным значением повторов
        List<String> resList = new ArrayList<>();
        resList.addAll(set);
        int max = 0;
        String resStr = null;
        for (String str: resList) {
            if (map.get(str).intValue() > max) {
                max = map.get(str).intValue();
                resStr = str;
            }
        }
        // отсортируем в естесственном порядке
        resList.sort(Comparator.naturalOrder());
        // выведем на экран статистику
        System.out.println("статистика");
        System.out.println("слово" + " : " + "количество повторений");
        for (String str: resList) {
            System.out.println(str + " : " + map.get(str).intValue());
        }
        System.out.println("выведем на консоль слово с максимальным количеством повторений");
        System.out.println("слово: " + resStr + " -  " + "количеством повторений: " + max);
        }
}

