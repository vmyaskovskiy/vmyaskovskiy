package ru.job4j.java20.task05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcMain {
    public double sum(double x, double y) {
        return x + y;
    }
    public double sub(double x, double y) {
        return x - y;
    }
    public double mul(double x, double y) {
        return x * y;
    }
    public double div(double x, double y) {
        return x / y;
    }


    public void calcmain() {
        Scanner scanner = new Scanner(System.in);
        // предлагаем пользователю выбрать операцию
        System.out.println("выберете операцию ‘+’, ‘-’, ‘*’ или ‘/’ ");
        // считываем
        String operator = scanner.next();
        try { // сделаем проверку на ввод числа
            // предлагаем ввести числа
            System.out.println("введите число x = ");
            double x = scanner.nextDouble();
            System.out.println("введите число y = ");
            double y = scanner.nextDouble();
            // в зависимости от считанного ранее оператора , производим действие над числами
            switch (operator) {
                case "+":
                    double sum = sum(x, y);
                    System.out.println(String.format("%.4f", sum));
                    break;
                case "-":
                    double sub = sub(x, y);
                    System.out.println(String.format("%.4f", sub));
                    break;
                case "*":
                    double mul = mul(x, y);
                    System.out.println(String.format("%.4f", mul));
                    break;
                case "/":
                    try {
                        // ArithmeticException возникает если делить Int ксли делить double
                        // возникает сообщение Infinity
                        // для моделирования перевел числа в int
                        double div = div(x, y);
                        System.out.println(String.format("%.4f", div));
                    } catch (ArithmeticException e) {
                        System.out.println("исключение - делить на ноль нельзя" + e);
                    }
                    break;
            }
        } catch (InputMismatchException ie) {
            System.out.println("исключение - введена не цифра " + ie);
        }
    }

    public static void main(String[] args) {
        CalcMain calcMain = new CalcMain();
        calcMain.calcmain();
    }
}
