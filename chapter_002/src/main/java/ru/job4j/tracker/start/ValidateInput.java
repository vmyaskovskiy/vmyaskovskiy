package ru.job4j.tracker.start;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("введите корректный пункт меню");
            } catch (NumberFormatException nfe) {
                System.out.println("введите корректные данные");
            }
        } while (invalid);
        return value;
   }
}

//ArrayIndexOutOfBoundsException