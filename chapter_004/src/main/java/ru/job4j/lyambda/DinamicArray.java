package ru.job4j.lyambda;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class DinamicArray<T> implements Iterable<T> {
    Object[] objects;
    private int index = 0;
    private int size = 3;
    private int modCount = 0;

    public DinamicArray() {
        this.objects = new Object[this.size];
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(T model) {
        if (index == size) {
            setSize(size * 2);
            this.objects = Arrays.copyOf(this.objects, getSize());
        }
        if (index >= this.objects.length) {
            throw new NoSuchElementException();
        }
        this.modCount++;
        this.objects[index++] = model;
    }
    public T get(int index) {
        if (index >= this.objects.length && index < 0) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[index];
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

