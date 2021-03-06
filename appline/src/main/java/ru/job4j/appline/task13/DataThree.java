package ru.job4j.appline.task13;
//Напишите программу, где пользователь должен ввести строку из слов, разделенных пробелами.
// Например: “I love java 8 Я люблю java 14 core1”. Выполните следующие действия:
// Выведите слова, состоящие только из латиницы.
//Выведите количество этих слов.

import java.util.Scanner;

public class DataThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу состоящую из слов на русском и латинице");
        String str = scanner.nextLine();
       // "I love java 8 Я люблю java 14 core1 !"
        String[] wordnew = str.split(" ");
        boolean test = true;
        int counter = 0;
        for(int i = 0; i < wordnew.length; i++) {
            char arrStr[] = wordnew[i].toCharArray();
            for(int j = 0; j < arrStr.length; j++) {
                if (!(((arrStr[j] >= 'a') && (arrStr[j] <= 'z')) || ((arrStr[j] >= 'A') && (arrStr[j] <= 'Z')))) {
                    test = false;
                }
            }
            if(test == true) {
                counter++;
                System.out.println("word = " + wordnew[i]);

            }  test = true;
        }
        System.out.println("counter = " + counter);
        }
}
