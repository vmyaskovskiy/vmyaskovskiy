package ru.job4j.appline.task05;

import java.util.Scanner;

public class OperatorF {
    //Напишите простой калькулятор:
    //Ввести 2 числа с клавиатуры, затем один из символов ‘+’, ‘-’, ‘*’ или ‘/’.
    //В зависимости от символа вывести в консоль результат выполнения соответствующей арифметической операции.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите число x = ");
        int x = scanner.nextInt();
        System.out.println("введите число y = ");
        int y = scanner.nextInt();
        System.out.println("введите один из символов ‘+’, ‘-’, ‘*’ или ‘/’ ");
        String operator = scanner.next();
        String addition = "+";
        String subtraction = "-";
        String multiplication = "*";
        String division = "/";
        if(addition.equals(operator)) {
            int sum = x + y;
            System.out.println(sum);
        } else if(subtraction.equals(operator)) {
            int sub = x - y;
            System.out.println(sub);
        } else if(multiplication.equals(operator)) {
            int mul = x * y;
            System.out.println(mul);
        } else if(division.equals(operator)) {
            if(y != 0) {
                System.out.println("попали в деление");
                int div = x / y;
                System.out.println(div);
            }
            else{
                System.out.println("на ноль делить нельзя");
            }
        } else {
            System.out.println("вы ввели некоректный символ");
        }
    }
}
