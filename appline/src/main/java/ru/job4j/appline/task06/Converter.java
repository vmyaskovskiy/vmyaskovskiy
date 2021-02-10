package ru.job4j.appline.task06;

import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите что переводить: 1 - масса, 2 - расстояние");
        int x = scanner.nextInt();
        if(x == 1) {
            System.out.println("Выберите единицу измерения: 1 - кг, 2 - гр, 3 - тонн");
            int y = scanner.nextInt();
            System.out.println("введите количество выбранных единиц:");
            int z = scanner.nextInt();
            switch (y){
                case 1:
                    int resKg = z * 1;
                    int resGr = z * 1000;
                    double resT = z/1000.0;
                    System.out.println("Результат:");
                    System.out.println("Килограмм: " + resKg);
                    System.out.println("Грамм: " + resGr);
                    System.out.println("Тонн: " + String.format("%.3f", resT));
                    break;
                case 2:
                    double resKg2 = z/1000.0;
                    int resGr2 = z * 1;
                    double resT2 = z/1000000.0;
                    System.out.println("Результат:");
                    System.out.println("Килограмм: " + String.format("%.3f", resKg2));
                    System.out.println("Грамм: " + resGr2);
                    System.out.println("Тонн: " + String.format("%.6f", resT2));
                    break;
                case 3:
                    double resKg3 = z * 1000;
                    int resGr3 = z * 1000000;
                    int resT3 = z * 1;
                    System.out.println("Результат:");
                    System.out.println("Килограмм: " + resKg3);
                    System.out.println("Грамм: " + resGr3);
                    System.out.println("Тонн: " + resT3);
                    break;
            }
        } else if(x == 2){
            System.out.println("Выберите единицу измерения: 1 - метр, 2 - миля, 3 - ярд, 4 - фут");
            int y = scanner.nextInt();
            System.out.println("введите количество выбранных единиц:");
            int z = scanner.nextInt();
            switch (y){
                case 1:
                    int resM = z * 1;
                    double resMil = z / 1609.34;
                    double resYar = z * 1.094;
                    double resFut = z * 3.281;
                    System.out.println("Результат:");
                    System.out.println("Метры: " + resM);
                    System.out.println("Мили: " + String.format("%.3f", resMil));
                    System.out.println("Ярды: " + String.format("%.2f", resYar));
                    System.out.println("Футы: " + String.format("%.2f", resFut));
                    break;
                case 2:
                    double resM2 = z * 1609.34;
                    int resMil2 = z * 1;
                    int resYar2 = z * 1760;
                    int resFut2 = z * 5280;
                    System.out.println("Результат:");
                    System.out.println("Метры: " + resM2);
                    System.out.println("Мили: " + resMil2);
                    System.out.println("Ярды: " + resYar2);
                    System.out.println("Футы: " + resFut2);
                    break;
                case 3:
                    double resM3 = z / 1.094;
                    double resMil3 = z / 1760.0;
                    int resYar3 = z * 1;
                    int resFut3 = z * 3;
                    System.out.println("Результат:");
                    System.out.println("Метры: " + String.format("%.3f", resM3));
                    System.out.println("Мили: " + String.format("%.3f", resMil3));
                    System.out.println("Ярды: " + resYar3);
                    System.out.println("Футы: " + resFut3);
                    break;
                case 4:
                    double resM4 = z / 3.281;
                    double resMil4 = z / 5280.0;
                    double resYar4 = z / 3.0;
                    int resFut4 = z * 1;
                    System.out.println("Результат:");
                    System.out.println("Метры: " + String.format("%.2f", resM4));
                    System.out.println("Мили: " + String.format("%.5f", resMil4));
                    System.out.println("Ярды: " + String.format("%.2f", resYar4));
                    System.out.println("Футы: " + resFut4);
                    break;
            }
        } else {
            System.out.println("вы ввели некорректное число");
        }
    }
}
