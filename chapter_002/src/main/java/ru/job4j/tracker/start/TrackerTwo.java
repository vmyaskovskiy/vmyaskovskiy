package ru.job4j.tracker.start;
import ru.job4j.tracker.models.*;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.*;
/**
 * Class Tracker решение задачи части 002 - урок Инкапсуляция.Реализовать класс Tracker 2.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class TrackerTwo {
    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    private  String generateId() {
        return String.valueOf(RN.nextInt());
    }
    private int generateIdTwo() {
        return Integer.valueOf(RN.nextInt());
    }

    /**
     * метод add добавляет заявки в массив.
     * @param  item входной параметр -  заявка.
     */
    public void add(Item item) {
        item.setId(generateIdTwo());
        this.items.add(item);
    }
    /**
     * метод replace редактирует, заменяет заявки в массиве.
     * @param  item входной параметр -  заявка.
     * @param id  входной параметр - id заявки по которой ищем нужную заявку.
     * @return res выходной параметр - true если заявка была изменена
     */
    public boolean replace(Integer id, Item item) {
        boolean res = false;
        Item result = item;
        for (int i = 0; i < this.items.size(); i++) {
        if (this.items.get(i).getId() == id && this.items.get(i) != null) {
           // this.items.get(i).setName(item.getName());
           // this.items.get(i).setDescription(item.getDescription());
           // this.items.get(i).setCreate(item.getCreate());
            this.items.set(this.items.get(i).getId(), item);
            res = true;
            break;
        } else {
            System.out.println("---заявки не найдены----");
        }
        } return res;
    }
    /**
     * метод delete удаляет заявки из массива.
     * @param id  входной параметр - id заявки по которой ищем нужную заявку.
     * @return result выходной параметр - true если заявка была удалена
     */
    public boolean delete(Integer id) {
        boolean result = false;
        int position = this.items.size();
        for (int i = 0; i < position; i++) {
            if (this.items.get(i) != null && this.items.get(i).getId() == id) {
                this.items.remove(i);
                result = true;
                break;
            }
        } return result;
    }
    /**
     * метод getAll находит все заявки в массиве.
     * @return  result  выходной параметр - возвращает копию массива this.items.
     */
    public List<Item> getAll() {
        return this.items;
    }
    /**
     * метод findByName находит все заявки в массиве.
     * @param name  входной параметр - Имя заявки по которой ищем нужную заявку.
     * @return  result  выходной параметр - возвращает массив из заявок с нужным именем.
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getName().equals(name)) {
                result.add(this.items.get(i));
            }
        }
        return result;
    }
    /**
     * метод findById находит заявку с нужным Id.
     * @param id  входной параметр - id заявки по которой ищем нужную заявку.
     * @return  result  выходной параметр - возвращает  заявку с нужным Id.
     */
    public Item findById(Integer id) {
        Item result = null;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId() != 0 && this.items.get(i).getId() == id) {
                result = this.items.get(i);
                break;
            } else {
                result = null;
                System.out.println("---заявки не найдены----");
            }
            break;
        } return result;
    }
}
