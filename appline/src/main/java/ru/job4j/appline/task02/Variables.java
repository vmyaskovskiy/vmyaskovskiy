package ru.job4j.appline.task02;
/**
 * Class Variables решение задачи  - Задача №2 - Типы данных
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class Variables {
    public static void main(String[] args) {
        //Создайте переменную типа с плавающей точкой с наибольшим диапазоном чисел. Присвойте ей произвольное дробное значени
        double b;
        b = -3456.14161D;
        System.out.printf("double %f %n", b);
        double g = 1.14161d;
        System.out.printf("double %f %n", g);
        double k = -1.14161;
        System.out.printf("double %f %n", k);
        // Создайте переменную целочисленного типа с наименьшим диапазоном чисел. Присвойте  ей наибольшее возможное значение.
        byte f;
        f = 127;
        System.out.println("f = " + f);
        byte c = 2 * 2 * 2 * 2 * 2 * 2 * 2 - 1;
        System.out.println("c = " + c);
        int d = 1;
        for (int i = 1; i < 8; i++) {
            d = d * 2;
        }
        byte e = (byte) (d - 1);
        System.out.println("e = " + e);
    }
}
