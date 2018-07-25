package ru.job4j.traсker.start;
import ru.job4j.traсker.models.*;

import java.awt.*;
import java.util.Random;
import java.util.*;
/**
 * Class Tracker решение задачи части 002 - урок Инкапсуляция.Реализовать класс Tracker 2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * метод add добавляет заявки в массив.
     * @param  item входной параметр -  заявка.
     */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
    }
    /**
     * метод replace редактирует, заменяет заявки в массиве.
     * @param  item входной параметр -  заявка.
     * @param id  входной параметр - id заявки по которой ищем нужную заявку.
     * @return res выходной параметр - true если заявка была изменена
     */
    public boolean replace(String id, Item item) {
        boolean res = false;
        Item result = item;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i].setName(result.getName());
                this.items[i].setDescription(result.getDescription());
                this.items[i].setCreate(result.getCreate());
                res = true;
                break;
            }
        }return res;
    }
    /**
     * метод delete удаляет заявки из массива.
     * @param id  входной параметр - id заявки по которой ищем нужную заявку.
     * @return result выходной параметр - true если заявка была удалена
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items != null && this.items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - (i + 1));
                this.position = this.position - 1;
                result = true;
                break;
            }
        } return result;
    }
    /**
     * метод getAll находит все заявки в массиве.
     * @return  result  выходной параметр - возвращает копию массива this.items.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
    /**
     * метод findByName находит все заявки в массиве.
     * @param name  входной параметр - Имя заявки по которой ищем нужную заявку.
     * @return  result  выходной параметр - возвращает массив из заявок с нужным именем.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.position];
        int j = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name)) {
                result[j++] = items[i];
            }
        }
        return Arrays.copyOf(result, j);
    }
    /**
     * метод findById находит заявку с нужным Id.
     * @param id  входной параметр - id заявки по которой ищем нужную заявку.
     * @return  result  выходной параметр - возвращает  заявку с нужным Id.
     */
    public Item findById(String id) {
        Item result = new Item();
        for (Item item : items) {
           if (item != null && item.getId().equals(id)) {
              result = item;
              break;
           }
        }
        return result;
    }
    /**
     * метод generateId генерирует уникальный id.
     * @return  String.valueOf(System.currentTimeMillis() + RN.nextInt())  выходной параметр - уникальный id.
     */
    private  String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
