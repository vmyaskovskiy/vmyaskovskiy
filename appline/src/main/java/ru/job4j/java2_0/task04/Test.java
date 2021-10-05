package ru.job4j.java2_0.task04;

public class Test {
    String type;
    @Override
    public String toString() {
        return "You are calling custom Dog class";
    }

    public void getType() {
        this.type = "strong";
    }

    public String getType1() {
        return type;
    }
    public void getType2() {
        this.type = "strong";
        return;
    }

    public static void main(String[] args) {
        String[] array = {"aa", "bb", "cc", "ab", "bc", "ac"};
        String expectedValue = "ab";
        for (int i = 0; i < array.length; i++) {
            if (expectedValue.equals(array[i])) {
                System.out.println("expected index is : " + i);
            }
        }
    }
}
