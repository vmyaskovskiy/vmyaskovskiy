package ru.job4j.inputoutput;

public class Out {
    public static void main(String[] args) {
        Args jvm = Args.of(args);
        System.out.println("hello");
        System.out.println(jvm.get("-d"));
    }
}
