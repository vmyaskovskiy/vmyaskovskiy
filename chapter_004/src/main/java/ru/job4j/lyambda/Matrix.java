package ru.job4j.lyambda;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] integersTwo = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(Arrays.stream(integersTwo).flatMap(integers1 -> Arrays.stream(integers1)).collect(Collectors.toList()));
    }
}
