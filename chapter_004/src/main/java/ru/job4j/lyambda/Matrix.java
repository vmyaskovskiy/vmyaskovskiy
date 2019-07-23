package ru.job4j.lyambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public List<Integer> convertToMatrix(Integer[][] integers) {
        List<Integer> res = Arrays.stream(integers).flatMap(integers1 -> Arrays.stream(integers1)).collect(Collectors.toList());
        return res;
    }
}
