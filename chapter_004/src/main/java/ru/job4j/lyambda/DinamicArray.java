package ru.job4j.lyambda;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class SimpleArray решение задачи 5.3.1. Создать динамический список на базе массива.[#143704]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class DinamicArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int size = 4;
    private int modCount = 0;

    public DinamicArray() {
        this.objects = new Object[this.size];
    }

    public void add(T model) {
        if (index == size) {
            size = size * 2; // расширяем массив при достижении лимита размера.
            this.objects = Arrays.copyOf(this.objects, getSize());
        }
        if (index >= this.objects.length) {
            throw new NoSuchElementException();
        }
        this.modCount++;
        this.objects[index++] = model;
    }

    public T get(int index) {
        if (index >= this.index) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[index];
    }

    public boolean getOnValue(T value) {
        for (int i = 0; i < this.index; i++) {
           if (this.objects[i] != null && this.objects[i].equals(value)) {
               return true;
           }
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }
    public int getModCount() {
        return this.modCount;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = this.modCount;
        Object[] objects = this.objects;
        int index = this.index;
        Iterator<T> iterator = new Iterator<T>() {
            private int ind = 0;
            @Override
            public boolean hasNext() {
                    return ind < index;
            }
            @Override
            public T next() {
                if (expectedModCount != getModCount()) {
                    throw new ConcurrentModificationException();
                } else if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[ind++];
            }
        };
        return iterator;
    }
}

