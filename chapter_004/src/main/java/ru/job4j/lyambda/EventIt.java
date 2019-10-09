package ru.job4j.lyambda;

import java.util.Iterator;

public class EventIt implements Iterator {
    private final int[] value;
    private  int indexI = 0;

    public EventIt(final int[] value) {
        this.value = value;
    }
    class MyException extends Exception {
        public MyException(String msg) {
            super(msg);
        }
    }

    @Override
    public boolean hasNext() {
        for (int i = indexI + 1; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        for (int i = indexI; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                int t = value[i];
                indexI = i + 1;
                return t;
            }
        }
        try {
            throw new MyException("NoSuchElementException");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
