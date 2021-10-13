package ru.job4j.appline.task09;
//Пользователь вводит размер массива и данные с клавиатуры в массив типа double.
//Посчитайте среднее арифметическое элементов массива.
//После этого произведите вывод массива на экран,
// где каждый элемент массива умножается на среднее арифметическое

import java.util.Scanner;

public class CircleThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размер массива");
        int l = scanner.nextInt();
        double res = 0;
        scanner.nextLine();
        Double[] myArray = new Double[l];
        System.out.println(" введите элементы массива вида x,y тип double");
        for (int i = 0; i < l; i++) {
            double m = scanner.nextDouble();
            myArray[i] = m;
            res = res + m;
        }
        System.out.println(" сумма элементов массива " + res);
        double resL = res / l;
        System.out.println("среднеарифмитическое " + resL);
        for (double k: myArray) {
            System.out.println(k * resL);
        }
    }
}
