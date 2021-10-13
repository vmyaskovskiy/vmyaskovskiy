package ru.job4j.tdd;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TestOut {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("result.txt")
                ))) {
            out.println("Hello, world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
