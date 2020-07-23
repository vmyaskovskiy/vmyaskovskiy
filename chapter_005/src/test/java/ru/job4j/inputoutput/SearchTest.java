package ru.job4j.inputoutput;

import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 *
 * Class SearchTest тестирование задачи  3. Сканирование файловой системы.[#143741]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class SearchTest {
    Search search = new Search();
    String path = "C:/projects/vmyaskovskiy/chapter_005/data";

    @Test
    public void whenPropertiesTreeFiles() {
        Predicate<String> condition = (s) -> s.contains(".properties");
        List<File> file = search.files(path, condition);
        assertThat(file.size(), is(3));
    }
    @Test
    public void whenPairWithoutComment() {
        Predicate<String> condition = (s) -> s.startsWith("server");
        List<File> file = search.files(path, condition);
        assertThat(file.size(), is(4));
    }
}
