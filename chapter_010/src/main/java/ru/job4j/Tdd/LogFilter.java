package ru.job4j.Tdd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {

    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        String substring = "404";
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = in.readLine()) != null) {
                if(line.contains(substring)){
                    list.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for(String str: log) {
            System.out.println(str);
        }
    }
}
