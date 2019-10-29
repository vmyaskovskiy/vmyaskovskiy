package ru.job4j.lyambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    Object[] objects;
    int index = 0;
    int size = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
        this.size = size;
    }

    public void add(T model) {
        if (index < size) {
            this.objects[index++] = model;
        } else {
            throw new NoSuchElementException();
        }
    }
    public T get(int index) {
        if (index < size) {
            return (T) this.objects[index];
        } else {
            return null;
        }
    }
    public void set(int index, T model) {
        if (index < size) {
            this.objects[index] = model;
        } else {
            throw new NoSuchElementException();
        }
    }
    public void remove(int index) {
        for (int i = index; i < this.objects.length - 1; i++) {
            objects[i] = objects[i + 1];
        }
        this.objects = Arrays.copyOf(this.objects, this.objects.length - 1);
    }
    @Override
    public Iterator<T> iterator() {
        Object[] objects = this.objects;
        Iterator<T> iterator = new Iterator<T>() {
            private int ind = 0;
            @Override
            public boolean hasNext() {
                if (ind < objects.length && objects[ind] != null) {
                    return true;
                }
                return false;
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
