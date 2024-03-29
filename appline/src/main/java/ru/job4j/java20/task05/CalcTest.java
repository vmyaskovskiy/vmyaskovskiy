package ru.job4j.java20.task05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) {
        CalcSum calcSum = new CalcSum();
        CalcDiv calcDiv = new CalcDiv();
        CalcSub calcSub = new CalcSub();
        CalcMulti calcMulti = new CalcMulti();
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
                    double sum = calcSum.calc(x, y);
                    System.out.println(String.format("%.4f", sum));
                    break;
                case "-":
                    double sub = calcSub.calc(x, y);
                    System.out.println(String.format("%.4f", sub));
                    break;
                case "*":
                    double mul = calcMulti.calc(x, y);
                    System.out.println(String.format("%.4f", mul));
                    break;
                case "/":
                        double div = calcDiv.calc(x, y);
                        if (Double.isInfinite(div)) {
                            System.out.println("исключение - делить на ноль нельзя");
                        } else {
                            System.out.println(String.format("%.4f", div));
                        }
                        break;
            }
            } catch (InputMismatchException ie) {
                System.out.println("исключение - введена не цифра " + ie);
        }
    }
}
