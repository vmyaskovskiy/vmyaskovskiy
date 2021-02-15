package ru.job4j.appline.task07;

import java.util.Scanner;

public class Circle {
    //Пользователь вводит размер массива и данные с клавиатуры в массив
    //Сравнить элементы массива с заранее заданными константами x, y, z.
    //Если массив содержит хотя бы одну из констант, вывести текст "Данное значение имеется в константах".
    public static void main(String[] args) {
        int x = 1;
        double y = 2.2;
        String z = "test test";
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размер массива");
        int l = scanner.nextInt();
        scanner.nextLine();
        String[] myArray = new String[l];
        System.out.println("введите введите данные массива");
        for(int i = 0; i < l; i++) {
            String s = scanner.nextLine();
            myArray[i] = s;
        }
        String x1 = Integer.toString(x);
        String y1 = Double.toString(y);
        for(String array: myArray) {
            if(array.equals(x1) || array.equals(y1) || array.equals(z)) {
                System.out.println("Данное значение " + array +  " имеется в константах");
                break;
            }
        }
    }
}
