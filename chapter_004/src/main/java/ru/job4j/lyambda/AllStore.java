package ru.job4j.lyambda;

import java.util.NoSuchElementException;

public class AllStore<T extends Base> implements Store {
    private int size = 0;
    public SimpleArray<T> simpleArray;
    public AllStore(int size) {
        this.size = size;
        simpleArray = new SimpleArray<>(this.size);
    }
    @Override
    public void add(Base model) {
        simpleArray.add((T) model);
    }
    @Override
    public boolean replace(String id, Base model) {
        for (int i = 0; i < this.size; i++) {
            if (simpleArray.get(i).getId() == id) {
                simpleArray.set(i, (T) model);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean delete(String id) {
        for (int i = 0; i < this.size; i++) {
            if (simpleArray.get(i).getId() == id) {
                simpleArray.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public Base findById(String id) {
        for (int i = 0; i < this.size; i++) {
            if (simpleArray.get(i).getId() == id) {
                return simpleArray.get(i);
            }
        }
        throw new NoSuchElementException();
    }
}
