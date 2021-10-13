package ru.job4j.appline.task14;

//Напишите программу, заполняющую массив из 15 элементов рандомными значениями в диапазоне от -20 до 20. Далее:
//Выведите максимальный и минимальный элемент массива.
//Из максимального и минимального значения выведите наибольшее по модулю.

import java.util.Random;

public class DataFour {
    public static void main(String[] args) {
        Double[] myArray = new Double[15];
        Double a = -20.0;
        Double b = 20.0;
        Random random = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = a + (Math.random() * ((b - a) + 1));
            System.out.println(myArray[i]);
        }
        double min = myArray[0];
        double max = myArray[0];
        for (int i = 0; i < myArray.length; i++) {
            min = Math.min(min, myArray[i]);
            max = Math.max(max, myArray[i]);

        }
        System.out.println("min = " + min + " " + "max = " + max);
        System.out.println("Max = " + Math.max(Math.abs(min), Math.abs(max)));
    }
}
