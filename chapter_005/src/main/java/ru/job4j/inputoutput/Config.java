package ru.job4j.inputoutput;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
/**
 * Class Config решение задачи  1. Читаем файл конфигурации[#143742]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void make(String line) {
        String[] res = line.split("=");
        this.values.put(res[0], res[1]);
    }

    // Реализуйте метод load по аналогии с методом toString. Метод load должен загружать пару ключ-значение в Map values.
    public void load() {
        String line;

        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while ((line = read.readLine()) != null) {
                if (!(line.equals("") || line.startsWith("//"))) {
                    make(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Реализуйте метод value(String key) он должен возвращать значение ключа.
    public String value(String key) {
        return this.values.get(key);
    }
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
