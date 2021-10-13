package ru.job4j.appline.task10;
//Задача №10_Циклы
//Напишите программу, где пользователь вводит данные с клавиатуры в матрицу,
// а после этого произведите вывод первой строки матрицы на экран,
// где каждый элемент умножается на 3. Размерность матрицы задается пользователем.

import java.util.Scanner;

public class CircleFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размер двумерного массива по вертикале");
        int k = scanner.nextInt();
        System.out.println("введите размер двумерного массива по горизонтале");
        int m = scanner.nextInt();
        Double[][] myArray = new Double[k][m];
        System.out.println("введите элементы массива");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                Double l = scanner.nextDouble();
                myArray[i][j] = l;
            }
        }
        for (int j = 0; j < m; j++) {
            System.out.print(myArray[0][j] * 3 + " ");
        }
        System.out.println();
    }
}
