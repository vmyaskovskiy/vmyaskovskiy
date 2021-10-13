package ru.job4j.java20.task03;

import java.util.Scanner;
/**
 * Class CalcAndFind решение задачи 3 - Простой калькулятор
 * плюс поиск слова в массиве с максимальной длинной
 * @author myaskovskiy_vv
 */
public class CalcAndFind {
    /**
     * метод реализующий простой калькулятор
     */
    public void calc() {
        Scanner scanner = new Scanner(System.in);
        // предлагаем пользователю выбрать операцию
        System.out.println("выберете операцию ‘+’, ‘-’, ‘*’ или ‘/’ ");
        // считываем
        String operator = scanner.next();
        // предлагаем ввести числа
        System.out.println("введите число x = ");
        double x = scanner.nextDouble();
        System.out.println("введите число y = ");
        double y = scanner.nextDouble();
        // в зависимости от считанного ранее оператора , производим действие над числами
        switch (operator) {
            case "+":
                double sum = x + y;
                System.out.println(String.format("%.4f", sum));
                break;
            case "-":
                double sub = x - y;
                System.out.println(String.format("%.4f", sub));
                break;
            case "*":
                double mul = x * y;
                System.out.println(String.format("%.4f", mul));
                break;
            case "/":
                if (y != 0) {
                    double div = x / y;
                    System.out.println(String.format("%.4f", div));
                }
                else {
                    System.out.println("на ноль делить нельзя");
                }
                break;
        }
    }
    /**
     * метод поиска слова в массиве с максимальной длинной
     */
    public void find() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размер массива");
        int l = scanner.nextInt();
        scanner.nextLine();
        String[] myArray = new String[l];
        System.out.println("введите данные массива");
        for (int i = 0; i < l; i++) {
            String s = scanner.nextLine();
            myArray[i] = s;
        }
        int max = 0;
        int k = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (max < myArray[i].length()) {
                max = myArray[i].length();
                k = i;
            }
        }
        System.out.println("слово с максимальной длинной: " + myArray[k]);
    }

    // основной метода mine реализующий логику
    public static void main(String[] args) {
        CalcAndFind calcAndFind = new CalcAndFind();
        Scanner scanner = new Scanner(System.in);
        // предлагаем пользователю выбрать операцию
        System.out.println("выберете операцию 1 - калькулятор, 2 - поиск максимального элемента ");
        // считываем
        String operator = scanner.next();
        // анализируем, что ввел оператор.
        if (operator.equals("1")) {
            calcAndFind.calc();
        } else if (operator.equals("2")) {
            calcAndFind.find();
        } else {
            System.out.println("  вы ввели некорректное число ");
        }
    }
}
