package ru.job4j.inputoutput;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
/**
 * Class Analizy решение задачи  2. Анализ доступности сервера.[#143743]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Analizy {
    String line;
    List<Element> list = new ArrayList<>();
    String startVal = "null";
    String finishVal = "null";
    // объект для хранения строчки с разбитием на ключ - значение
    class Element {
        String key;
        String value;
        public Element(String key, String value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return key + " " + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Element element = (Element) o;
            return Objects.equals(key, element.key)
                    && Objects.equals(value, element.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    // преобразование записанного лога и запись в коллекцию
    public void makeList(String line) {
        String res[] = line.split(" ");
        Element element = new Element(res[0], res[1]);
        this.list.add(element);
    }
    // метод вычисления диапазонов , возвращат коллекцию диапазонов
    public List<Element> getValue() {
        Iterator<Element> it = this.list.iterator();
        List<Element> res = new ArrayList<>();
        Element el;

        while (it.hasNext()) {
            Element f = it.next();
            String start = f.key;
            String startV = f.value;

            if ((start.equals("500") || start.equals("400"))) {
                if (this.startVal.equals("null")) {
                    this.startVal = startV;
                }
            }
            else if (!this.startVal.equals("null")) {
                this.finishVal = startV;
                el = new Element(this.startVal, this.finishVal);
                res.add(el);
                this.startVal = "null";
                this.finishVal = "null";
            }
        }
        return res;
    }
    // метод считывания лога , анализ по методу данных, запись полученных данных в выходной файл
    public void unavailable(String path, String target) {
         try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            while ((line = read.readLine()) != null) {
                makeList(line);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

