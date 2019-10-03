package ru.job4j.lyambda;

import java.util.Iterator;

public class IterratorArray implements Iterator {
    private final int[][] arrI;
    private  int indexI = 0;
    private  int indexJ = 0;

    public IterratorArray(final int[][] arrI) {
        this.arrI = arrI;
    }


    public boolean hasNext() {
        int t = indexJ;
        for (int i = this.indexI; i < arrI.length; i++) {
                if (arrI[i].length != 0) {
                    if (t < arrI[i].length) {
                        return true;
                    }
                        t = 0;
                }
        } return false;
    }



    public Object next() {
        for (int i = indexI; i < arrI.length; i++) {
            if (arrI[i].length != 0) {
                if (indexJ < arrI[i].length) {
                    int value = arrI[i][indexJ];
                    indexI = i;
                    indexJ++;
                    return value;
                } else {
                    indexI++;
                    indexJ = 0;
                }
            } else {
                indexI++;
                indexJ = 0;
            }
        } return 0;
    }
}
