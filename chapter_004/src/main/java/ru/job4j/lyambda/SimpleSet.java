package ru.job4j.lyambda;

import java.util.Iterator;
/**
 * Class SimpleSet решение задачи 1 Реализовать коллекцию Set на массиве[#143733]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<E> implements Iterable<E> {
    private DinamicArray<E> simpleList = new DinamicArray<>();

    public boolean add(E e) {
        if (!simpleList.getOnValue(e)) {
            simpleList.add(e);
            return true;
        }
        return false;
    }

    public E get(int index) {
        return (E) simpleList.get(index);
    }

    public boolean getValue(E value) {
        return simpleList.getOnValue(value);
    }

    @Override
    public Iterator<E> iterator() {
        return simpleList.iterator();
    }
}
