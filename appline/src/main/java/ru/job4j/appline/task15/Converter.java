package ru.job4j.appline.task15;
//Напишите программу конвертер валют.
// Программа должна переводить рубли в доллары по текущему курсу.
// Пользователь вводит текущий курс и количество рублей.
// Итоговое значение должно быть округлено до двух знаков после запятой.
// Пример для теста работы программы:
        //Курс доллара: 67,55
        //Количество рублей: 1000
        //Итого: 14,80 долларов

import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текущий курс");
        Double cur = scanner.nextDouble();
        System.out.println("Введите количество рублей");
        Double rub = scanner.nextDouble();
        Double res = rub / cur;
        System.out.println("Курс доллара: " + cur);
        System.out.println("Количество рублей: " + rub);
        System.out.print("Итого: " + String.format("%.2f", res) + " долларов");
    }
}
