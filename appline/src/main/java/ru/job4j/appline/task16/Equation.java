package ru.job4j.appline.task16;

import java.util.Scanner;
//Напишите программу, которая позволит решить простое уравнение относительно x.
// Программа принимает на вход строку длиной 5 символов.
// Второй символ строки является знаком ‘+’ или ‘-’, четвертый символ строки ‘=’.
// Первым, третьим и пятым символом являются две цифры (от 0 до 9) и
// буква ‘x’ (обозначает неизвестное) в любом порядке. Нужно найти неизвестное.

// примем за условие , что Х = 1, не Х = 0, "+" = 1 "-" = 0
// составим матрицу значений вида:
// Х + В = С  --> 1100
// Х - В = С  --> 1000
// после составления кода на основе введенных значений, анализируем код и производим соответствующее решение.
// коду 1100 соответствует решение С - В

public class Equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int result = 0;
        String[] myArray = new String[5];
        System.out.println("Введите первое значение или Х");
        myArray[0] = scanner.next();
        if (myArray[0].equals("x")) {
            a = 1;
        }
        System.out.println("Введите знак + или - ");
        myArray[1] = scanner.next();
        if (myArray[1].equals("+")) {
            b = 1;
        }
        System.out.println("Введите второе значение или Х");
        myArray[2] = scanner.next();
        if (myArray[2].equals("x")) {
            c = 1;
        }
        System.out.println("Введите знак =");
        myArray[3] = scanner.next();
        System.out.println("Введите значение уравнения или Х");
        myArray[4] = scanner.next();
        if (myArray[4].equals("x")) {
            d = 1;
        }
        String res = new String(String.valueOf(a) + String.valueOf(b) + String.valueOf(c) + String.valueOf(d));
        if (res.equals("1100")) {
            result = Integer.valueOf(myArray[4]) - Integer.valueOf(myArray[2]);
        } else if (res.equals("1000")) {
            result = Integer.valueOf(myArray[4]) + Integer.valueOf(myArray[2]);
        } else if (res.equals("0110")) {
            result = Integer.valueOf(myArray[4]) - Integer.valueOf(myArray[0]);
        } else if (res.equals("0010")) {
        result = Integer.valueOf(myArray[0]) - Integer.valueOf(myArray[4]);
        } else if (res.equals("0101")) {
            result = Integer.valueOf(myArray[0]) + Integer.valueOf(myArray[2]);
        } else if (res.equals("0001")) {
            result = Integer.valueOf(myArray[0]) - Integer.valueOf(myArray[2]);
        }
        System.out.println("Ввод: " + myArray[0] + " " + myArray[1] + " " + myArray[2] + " " + myArray[3] + " " + myArray[4]);
        System.out.println("Вывод: " + result);
    }
}
