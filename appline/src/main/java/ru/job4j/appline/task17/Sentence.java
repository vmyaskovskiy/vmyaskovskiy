package ru.job4j.appline.task17;
//Напишите программу, где пользователь вводит сначала количество строк n, затем сами строки.
// Среди данных строк найти строку с максимальным количеством различных символов.
// Если таких строк будет много, то вывести первую.
        //Пример для теста работы программы:
        //Количество строк: 3
        //Строка 1: привет
        //Строка 2: анализ
        //Строка 3: 111111111111
        //Ответ: привет

import java.util.Scanner;

public class Sentence {
    // метод для вычисления количества различных букв в слове.
    public long strMany(String str) {
        long res2 = str.toLowerCase().chars().distinct().count();
    return res2;
    }


    public static void main(String[] args) {
        Sentence sentence = new Sentence();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк l");
        int l = scanner.nextInt();
        scanner.nextLine();
        String[] myArray = new String[l];
        // заплним массив строк
        for(int i = 0; i < l; i++) {
            System.out.println("Введите сетроку " + (i + 1));
            myArray[i] = scanner.nextLine();
        }
        long[] countA = new long[myArray.length];
        //есди строк много, выведем первую
        if(myArray.length > 2) {
            System.out.println("Количество строк: " + myArray.length);
            for(int i = 0; i < myArray.length; i++) {
                System.out.println("Строка " + (i + 1) + ":" + " " + myArray[i]);
            }
            System.out.println("Ответ: " + myArray[0]);
        // иначе заполним массив значениями сколько в каждом слове различных букв
        } else {
            for (int i = 0; i < myArray.length; i++) {
                countA[i] = sentence.strMany(myArray[i]);
            }
            long max = countA[0];
            int resI = 0;
            // вычислим максимальное значение
            for(int i = 1; i < countA.length; i++) {
                max = Math.max(max, countA[i]);
            }
            // узнаем слово для которого максимальное значение
            for(int i = 1; i < countA.length; i++) {
                if(max == countA[i]) {
                    resI = i;
                }
            }
            // сформируем ответ
            System.out.println("Количество строк: " + myArray.length);
            for(int i = 0; i < myArray.length; i++) {
                System.out.println("Строка " + (i + 1) + ":" + " " + myArray[i]);
            }
            System.out.println("Ответ: " + " Кол-во разл букв = " + max + "  фраза: " + myArray[resI]);
        }
    }
}
