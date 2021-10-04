package ru.job4j.Tdd;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
//
public class ResultFile {
    public int[][] mul() {
        int[][] res = new int[10][11];
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j <= 10; j++) {
                res[i][j] = i*j;
            }
        }
        return res;
    }
//
    public static void main(String[] args) {
        ResultFile resultFile = new ResultFile();
        int[][] res = resultFile.mul();
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for(int i = 1; i < 10; i++) {
                for(int j = 1; j <= 10; j++) {
                    Integer int3 = res[i][j];
                  out.write(int3.toString().getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
