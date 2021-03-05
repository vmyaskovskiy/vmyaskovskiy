package ru.job4j.appline.task12;

import java.util.Scanner;

//Напишите программу, принимающую на вход строку “I like Java!!!”, которая будет выполнять следующие действия:

public class DataTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку I like Java!!!");
        String str = scanner.nextLine();
        System.out.println(str.equals("I like Java!!!"));
        //Проверить, содержит ли строка подстроку “Java” (используйте contains()).
        //Проверить, начинается ли строка с подстроки “I like” (используйте startsWith()).
        //Проверить, заканчивается ли строка с подставки “!!!” (используйте endsWith()).
        boolean one = str.contains("Java");
        boolean two = str.startsWith("I like");
        boolean three = str.endsWith("!!!");
        //Если 3 предыдущих условия верны, выведите данную строку, преобразованную к верхнему регистру.
        if(one && two && three == true ) {
            System.out.println(str.toUpperCase());
        }
        //Замените все символы ‘a’ на ‘о’ и введите подстроку “Jovo” на экран  (используйте substring()).
        String replace = str.replace("a", "o");
        System.out.println(replace.substring(7,11));
    }
}
