package ru.job4j.appline.task11;

import java.util.Scanner;

public class Data {
   // Напишите программу:
    //Ввести первое  число с клавиатуры и записать его в строковую переменную.
    //Ввести второе число с клавиатуры и сохранить его в целочисленную переменную типа int.
    //Сравнить 2 числа и вывести большее на экран .
    //Выведите также меньшее число на экран, предварительно переконвертировать его в тип double.
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Введите первое  число с клавиатуры, для чисел с дробной частью, используйте разделитель ,");
       String strL = Double.toString(scanner.nextDouble());
       System.out.println("Введите второе  число с клавиатуры, для чисел с дробной частью, используйте разделитель ,");
       int m = (int) scanner.nextDouble();
       System.out.println("максимальное число " + Math.max(Double.valueOf(strL), Double.valueOf(m)));
       System.out.println("минимальное число " + Math.min(Double.valueOf(strL), Double.valueOf(m)));
   }
}
