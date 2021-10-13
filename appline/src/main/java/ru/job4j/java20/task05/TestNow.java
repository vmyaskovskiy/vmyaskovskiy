package ru.job4j.java20.task05;

public class TestNow {
    String str1 = new String("Test1");
    String str2 = new String("Test2");
    int num = 5;
    public static void main(String[] args) {
        TestNow testNow = new TestNow();
        TestNow testNow1 = new TestNow();
        System.out.println(testNow.equals(testNow1));
    }
}
