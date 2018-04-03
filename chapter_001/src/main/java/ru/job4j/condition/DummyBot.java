package ru.job4j.condition;
/**
 * Class DummyBot решение задачи части 001 - урок Глупый бот 3.1.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {

    /**
     * конструктор для класса DummyBot.
     * @param question входной параметр вопрос к Боту.
     * @return rsl выходной параметр Ответ Бота.
     */

    public String respBot(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if (question.equals("Привет, Бот.")) {
            rsl = "Привет, умник.";
        } else if (question.equals("Пока.")) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
