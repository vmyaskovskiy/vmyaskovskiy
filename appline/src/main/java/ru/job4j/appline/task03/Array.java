package ru.job4j.appline.task03;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        for(int i: array) {
            System.out.print(i);
        }
        System.out.println();
        int l = array.length - 1;
        int last = array[l];
        array[l] = array[0];
        array[0] = last;
        for(int i: array) {
            System.out.print(i);
        }
        System.out.println();
        //System.out.println(array[l] + (array[l - 2]));
        System.out.println(array[0] + (array[l - (l/2)]));

    }


}
