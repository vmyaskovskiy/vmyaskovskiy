package ru.job4j.appline.task01;

import java.util.Scanner;

/**
 * Class Welcome2 решение задачи  - Задача №1 - Первая программа
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Welcome2 {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        double[] tt = {1.9, 2.9, 3.4, 3.5};
        double max = tt[0];
        System.out.println(tt.length);
        for(int i = 0; i<tt.length; i++) {
            if(tt[i] > max) {
                max = tt[i];
            }
        }
        System.out.println(max);
        double total = 0;
        for(int i = 0; i<tt.length; i++) {
            total +=tt[i];
            }
        System.out.println(total);


        int[] rr = {1,2,3,4,5,6,7,8,9};
        System.out.println(rr[rr.length-3]);
        float[] f1,f2;
        f1 = new float[10];
        f2=f1;
        System.out.println(f2[0]);
        byte dd[][] = {{1,2,3,4},{1,2,3}};
        System.out.println(dd[1].length + " " + dd.length);
        //boolean a;
        int a,b,c;
        a = 1;
        b = 2;
        c = 3;
        //b += a *=2;
        b = c-- % ++a;
        System.out.println("b= " + b);
        System.out.println(a);
       // System.out.println(a = 3%1 == b);
        //System.out.println(a = 3%4 == b);
       // System.out.println(a = 3%2 == b);
       // System.out.println(a = 3%3 == b);
        boolean tr = true;
        boolean ff = true;
        System.out.println(tr = ff);
        System.out.println("введите число ");
        //Scanner scanner = new Scanner(System.in);
        //int number = scanner.nextInt();
        //String numberS = scanner.next();
       // if(number == 1) {
        //    System.out.println("ввели " + number);
        //}
        if(true&&false) {
            System.out.println("fff");
        } else {
            System.out.println("ttt");
        }
    }
}