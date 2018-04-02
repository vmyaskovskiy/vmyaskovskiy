package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class DummyBotTest тест задачи части 001 - урок Глупый бот 3.1.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class DummyBotTest {

    @Test
    public void dummyBotGreet() {
        DummyBot bot = new DummyBot();
        String rsl = bot.respBot("Привет, Бот.");
        assertThat(rsl, is("Привет, умник."));
    }
    @Test
    public void dummyBotBy() {
        DummyBot bot = new DummyBot();
        String rsl = bot.respBot("Пока.");
        assertThat(rsl, is("До скорой встречи."));
    }
    @Test
    public void dummyBotUnknown() {
        DummyBot bot = new DummyBot();
        String rsl = bot.respBot("Ты Бот");
        assertThat(rsl, is("Это ставит меня в тупик. Спросите другой вопрос."));
    }
}
