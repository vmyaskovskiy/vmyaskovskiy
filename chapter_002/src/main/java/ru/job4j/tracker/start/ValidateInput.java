package ru.job4j.tracker.start;
/**
 * Class ValidateInput выполенение задачи части 002 - ООП. Шаблон Декоратор для валидатора.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements Input {
    private final Input input;
    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public Integer ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public String askTwo(String question) {
        return String.valueOf(this.input.askTwo(question));
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
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
