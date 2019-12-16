package ru.job4j.lyambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class SimpleArray решение задачи  Создать статичный список на базе массива.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int size = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
        this.size = size;
    }
    public void add(T model) {
        if (index >= this.objects.length) {
             throw new NoSuchElementException();
        }
        this.objects[index++] = model;
    }
    public T get(int index) {
        if (index >= this.objects.length && index < 0) {
            throw new NoSuchElementException();
        }
            return (T) this.objects[index];
    }
    public boolean set(int index, T model) {
            if (index >= this.objects.length && index < 0) {
                return false;
            }
                this.objects[index] = model;
           return true;
    }
    public boolean remove(int index) {
        if (index >= this.objects.length && index < 0) {
            return false;
        }
        for (int i = index; i < this.objects.length - 1; i++) {
            objects[i] = objects[i + 1];
        }
        this.objects = Arrays.copyOf(this.objects, this.objects.length - 1);
        return true;
    }
    public int getLength() {
        return this.objects.length;
    }
    public int getSize() {
        return this.size;
    }
    @Override
    public Iterator<T> iterator() {
        Object[] objects = this.objects;
        Iterator<T> iterator = new Iterator<T>() {
            private int ind = 0;
            @Override
            public boolean hasNext() {
                return ind < objects.length;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[ind++];
            }
        };
        return iterator;
    }
}
