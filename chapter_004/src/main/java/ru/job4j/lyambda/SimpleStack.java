package ru.job4j.lyambda;

public class SimpleStack<T> {
    private DinamicArrayList<T> array = new DinamicArrayList<>();
    public void push(T value) {
        array.add(value);
    }
    public T poll() {
        T res = array.getFirst();
        array.delete();
        return res;
    }
}
