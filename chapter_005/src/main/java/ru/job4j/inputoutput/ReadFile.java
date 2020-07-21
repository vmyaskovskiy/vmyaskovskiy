package ru.job4j.inputoutput;

import java.io.File;
import java.io.FileInputStream;

public class ReadFile {

    public  void div(int first, int second) {
        if (second == 0) {
            throw new IllegalArgumentException("Div by 0");
        }
        int result = first / second;
        System.out.println("res = " + result);
    }

    public static void main(String[] args) {

         ReadFile readFile = new ReadFile();
         readFile.div(1, 2);

        try (FileInputStream in = new FileInputStream("C:/projects/vmyaskovskiy/chapter_005/1.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int i = Integer.parseInt(line);
                if (i % 2 == 0) {
                System.out.println(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
