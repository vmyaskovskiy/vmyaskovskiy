package ru.job4j.inputoutput;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class ConfigTest тестирование задачи  1. Читаем файл конфигурации[#143742]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Slava Myaskovskiy")
        );
    }
    @Test
    public void whenPairWithout() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("nameOne"),
                is("Petr Arsentev")
        );
    }
    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Slava Myaskovskiy")
        );
        assertThat(
                config.value("nameTwo"),
                is("Vova")
        );
    }
}
