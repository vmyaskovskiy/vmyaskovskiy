package ru.job4j.inputoutput;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class ZipTest тестирование задачи  4. Архивировать проект. [#143744]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */

public class ZipTest {
    Zip zip = new Zip();

    @Test
    public void whenPropertiesTreeFiles() {
        List<File> files = zip.seekBy("C:/projects/vmyaskovskiy/chapter_005/data", "log");
         zip.pack(files, new File("C:/projects/vmyaskovskiy/chapter_005/pom3.zip"));
    }
}
