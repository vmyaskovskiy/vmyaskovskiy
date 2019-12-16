package ru.job4j.lyambda;

import java.util.Iterator;

public class IterratorArray implements Iterator {
    private final int[][] arrI;
    private  int indexI = 0;
    private  int indexJ = 0;

    public IterratorArray(final int[][] arrI) {
        this.arrI = arrI;
    }
    class MyException extends Exception {
        public MyException(String msg) {
            super(msg);
        }
    }
    public boolean hasNext() {
        for (int i = indexI; i < arrI.length; i++) {
            if (arrI[i].length != 0) {
                if (indexJ < arrI[i].length) {
                    return true;
                } else {
                    indexI++;
                    indexJ = 0;
                }
            } else {
                indexI++;
                indexJ = 0;
            }
        }
        return false;
    }

    public Object next() {
        int value = 0;
        if (hasNext()) {
            return arrI[indexI][indexJ++];
        } else {
            try {
                throw new MyException("NoSuchElementException");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static void main(String[] args) {
        IterratorArray it = new IterratorArray(new int[][]{{1}, {3}});
        it.hasNext();
        it.next();
        it.hasNext();
        it.next();
        System.out.println(it.hasNext());
        it.next();
    }

}

