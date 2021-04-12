package ru.job4j.java2_0.task04;

/**
 * Class Array решение задачи 4.1 - Заполнение массива
 * @author myaskovskiy_vv
 */
public class Array {
    //Массив размерностью 20, заполняется случайными целыми числами от -10 до 10.
    //Найти максимальный отрицательный и минимальный положительный элементы массива.
    //Поменять их местами.
    public static void main(String[] args) {
        Double[] myArray = new Double[20];
        Double a = -10.0;
        Double b = 10.0;
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = a + (Math.random() * ((b - a)));
            System.out.println(myArray[i]);
        }
        double min = 11;
        double max = -11;
        int iMin = 0;
        int iMax = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > 0) {
                min = Math.min(min, myArray[i]);
                if (myArray[i] == min) {
                    iMin = i;
                }
            } else {
                max = Math.max(max, myArray[i]);
                if (myArray[i] == max) {
                    iMax = i;
                }
            }
        }
        System.out.println("min = " + myArray[iMin] + "  " + "max = " + myArray[iMax]);
        System.out.println("поменяем местами");
        Double res = myArray[iMin];
        myArray[iMin] = myArray[iMax];
        myArray[iMax] = res;
        System.out.println("min = " + myArray[iMin] + "  " + "max = " + myArray[iMax]);
    }
}
