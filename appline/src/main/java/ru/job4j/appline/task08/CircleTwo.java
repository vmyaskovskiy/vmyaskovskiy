package ru.job4j.appline.task08;

import java.util.Scanner;
//Напишите программу, где пользователь вводит любое целое положительное число n.
// А программа суммирует все нечетные числа от 1 до введенного пользователем числа n.

public class CircleTwo {
    public int sum(int l) {
        int res = 0;
        for(int i = 1; i <= l; i = i + 2) {
            res = res + i;
        }
        return res;
    }
    public static void main(String[] args) {
        CircleTwo circleTwo = new CircleTwo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите любое целое положительное число n");
        int l = scanner.nextInt();
        if(l % 2 == 0) {
            l--;
        }
        System.out.println(" res = " + circleTwo.sum(l));
    }
}
