package ru.job4j.appline.task04;

import java.util.Scanner;
//Задача №4_Операторы new
public class Operator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите число x = ");
        double x = scanner.nextDouble();
        System.out.println("введите число y = ");
        double y = scanner.nextDouble();
        System.out.println("введите число z = ");
        double z = scanner.nextDouble();
        System.out.println(x + " " + y + " " + z);
        double a = (x + y + z)/3;
        System.out.println(" среднее " + a);
        double d = a/2; // без округления
        int b = (int) a/2; // округление путем отбрасывания дробной части
        double result = Math.floor(d); // округление в меньшую сторону
        double resultTwo = Math.ceil(d); // округление в большую сторону
        System.out.println(" без округления " + d);
        System.out.println(" округление в меньшую сторону путем отбрасывания дробной части " + b);
        System.out.println(" округление в меньшую сторону " + result);
        System.out.println(" округление в большую сторону " + resultTwo);
        if(result > 3) {
            System.out.println("Программа выполнена корректно");
        }
    }
}
