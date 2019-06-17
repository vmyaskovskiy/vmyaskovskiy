package ru.job4j.lyambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MultyFunc {

     public List<Double> multiple(int start, int finish,
                            Function<Double, Double> func) {
        List<Double> bufer = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            bufer.add(func.apply((double) i));
        }
        return bufer;
    }
}
