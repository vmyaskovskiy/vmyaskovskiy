package ru.job4j.lyambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * pppp
 */
public class Calc {

    public interface Operation {
        double calc(int left, int right);
    }

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int i = start; i != finish; i++) {
            media.accept(op.apply(value, i));
        }
    }

    public static void main(String[] args) {
        Calc calc = new Calc();
        calc.multiple(0, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Mult %s * %s = %s %n", value, index, result);
                    return result;
                },
        result -> System.out.println(result)
        );
    }
}