package ru.job4j.lyambda;

import java.util.Iterator;

public class IterratorArray implements Iterator {
    private final int[][] arrI;
    private  int k = 0;
    private  int t = 0;

    public IterratorArray(final int[][] arrI) {
        this.arrI = arrI;
    }
    public boolean hasNext() {
            return arrI.length > k && arrI[k].length > t;
    }
    public Object next() {
        for (int i = 0; i < arrI.length; i++) {
            for (int j = 0; j < arrI[i].length; j++) {
                if (i == k && j == t) {
                    if (t < arrI[i].length - 1) {
                        int value = arrI[i][j];
                        k = i;
                        t = j+1;
                        return value;
                    } else if (k < arrI.length ) {
                        int value = arrI[i][j];
                        k = i + 1;
                        t = 0;
                        return value;
                    }
                }
            }
        }
        return 0;
    }
}
