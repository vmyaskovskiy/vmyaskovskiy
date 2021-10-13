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


        System.out.println("Введите уравнение вида х +/- в = с , цифры положительные (от 0 до 9)");
        String eq = scanner.nextLine();
        char[] chars = eq.toCharArray();
        String[] myArray = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            myArray[i] = String.valueOf(chars[i]);
            if (i == 0 && myArray[i].equals("x")) {
                a = 1;
            } else if (i == 1 && myArray[i].equals("+")) {
                b = 1;
            } else if (i == 2 && myArray[i].equals("x")) {
                c = 1;
            } else if (i == 4 && myArray[i].equals("x")) {
                d = 1;
            }
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
