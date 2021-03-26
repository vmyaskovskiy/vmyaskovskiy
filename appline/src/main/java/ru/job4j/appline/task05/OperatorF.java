package ru.job4j.appline.task05;

import java.util.Scanner;

public class OperatorF {
    //Circle
    //Напишите простой калькулятор:
    //Ввести 2 числа с клавиатуры, затем один из символов ‘+’, ‘-’, ‘*’ или ‘/’.
    //В зависимости от символа вывести в консоль результат выполнения соответствующей арифметической операции.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите число x = ");
        double x = scanner.nextDouble();
        System.out.println("введите число y = ");
        double y = scanner.nextDouble();
        System.out.println("введите один из символов ‘+’, ‘-’, ‘*’ или ‘/’ ");
        String operator = scanner.next();
        switch (operator) {
            case "+":
                double sum = x + y;
                System.out.println(sum);
                break;
            case "-":
                double sub = x - y;
                System.out.println(sub);
                break;
            case "*":
                double mul = x * y;
                System.out.println(String.format("%.4f", mul));
                break;
            case "/":
                if(y != 0) {
                    double div = x / y;
                    System.out.println(String.format("%.4f", div));
                }
                else{
                    System.out.println("на ноль делить нельзя");
                }
                break;
            }
    }
}
